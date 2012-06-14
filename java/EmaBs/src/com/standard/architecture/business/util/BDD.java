/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.standard.architecture.business.util;
 
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Topagui
 */
public class BDD
{
    public Connection conn = null;
    public String db_name;
    private boolean abIsConnected;

    public BDD(String psBase)
    {
        this.db_name = psBase;
    }
    public boolean connect()
    {
        boolean res = false;

            try
            {
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
            }
            catch(Exception e)
            {
                    e.printStackTrace();
            }

            try
            {
                    this.conn = DriverManager.getConnection("jdbc:mysql:///?user=admin");
                    res = true;
            }
            catch(SQLException e)
            {
                System.out.println("sql exception");

                while (e!=null)
                {
                  System.out.println(e.getErrorCode());
                  System.out.println(e.getMessage());
                  System.out.println(e.getSQLState());
                  e.printStackTrace();
                  e=e.getNextException();
                }
            }
            catch(Exception e)
            {
            	e.printStackTrace();
            }
        setIsConnected(res);
        return res;
    }
    public boolean deconnect()
    {
        boolean res;
        res = false;
        try {
            conn.close();
            res = true;
        } catch (SQLException ex) {
            Logger.getLogger(BDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        setIsConnected(!res);
        return res;
    }
    /*
     * get
     */
    public boolean getIsConnected()
    {
        return abIsConnected;
    }
    /*
     *Set
     */
    private void setIsConnected(boolean pbIsConnected)
    {
        abIsConnected = pbIsConnected;
    }
    /*
     * Méthode
     */
    /*
     * Lancement d'une requete de type SELECT
     */
    public ResultSet lancerRequette(String spQuery)
    {
        ResultSet res = null;
        System.out.println(spQuery);
        if(connect())
        {
            try
            {
            	Statement stat = this.conn.createStatement();
                stat.executeQuery("use " + db_name);
                res = stat.executeQuery(spQuery);
            }
            catch(SQLException e)
            {
                System.out.println("sql exception");

                while (e!=null)
                {
                  System.out.println(e.getErrorCode());
                  System.out.println(e.getMessage());
                  System.out.println(e.getSQLState());
                  e.printStackTrace();
                  e=e.getNextException();
                }
            }
            catch(Exception e)
            {
                    e.printStackTrace();
            }
             //if(!deconnect())
            {
                //probleme de deconnection à la base
            }
        }

        return res;
    }
    public ArrayList<String> recupereInformation(String psRequete)
    {
        ArrayList<String> res = new ArrayList<String>();

        //System.out.println(psRequete);
        try
        {
            ResultSet result = lancerRequette(psRequete);
            if(!result.wasNull())
            {
                ResultSetMetaData rsmd = result.getMetaData();
                int nbCols = rsmd.getColumnCount();
                boolean encore = result.next();
                while (encore)
                {
                    System.out.print("         ");
                    for (int i = 1; i <= nbCols; i++)
                    {
                        System.out.print(result.getString(i) + " ");
                        res.add(result.getString(i));
                    }
                    System.out.println();
                    encore = result.next();
                }
                if(!deconnect())
                {
                    //probleme lors de la deconnexion
                }
            }
        }
        catch(SQLException e)
        {
            System.out.println("sql exception");
            while (e!=null)
            {
                System.out.println(e.getErrorCode());
                System.out.println(e.getMessage());
                System.out.println(e.getSQLState());
                e.printStackTrace();
                e=e.getNextException();
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return res;
    }
    /*-------------------------------------------------------------------------------------
     *
     * La fonction fabrique une requête SQL UPDATE multi-tables
     * en fonction de la matrice et de la clause where reçues en paramètres
     *
     * NOTE 1 : la matrice de paramètre et une matrice de type String[x][3] contenant :
     * 			| nom_tableX | nom_champX | nouvelle_valeurX |
     *
     * NOTE 2 : toutes les tables référées dans la clause where doivent être déclarées dans
     * 			la matrice[x][3] EN PREMIER et de la manière suivante :
     * 			| nom_tableX | null | null |
     *
     * -------------------------------------------------------------------------------------
     */
    public boolean updateTables(String[][] params, String where)
    {
    	/* Exemple d'utilisation de la classe :

      	String[][] params = new String[5][3];

		params[0][0] = "badge";
		params[0][1] = null;
		params[0][2] = null;

		params[1][0] = "forfait";
		params[1][1] = null;
		params[1][2] = null;

		params[2][0] = "client";
		params[2][1] = "adresse_mail";
		params[2][2] = "m.bauer@jaimelespoils.net";

		params[3][0] = "client";
		params[3][1] = "adresse_physique";
		params[3][2] = "438 chemin de carsalade";

		params[4][0] = "associe";
		params[4][1] = "TypeForfait";
		params[4][2] = "Forfait3";
     */

        boolean res = false;

        String query = "null";

         if(connect())
         {
        	 query = "UPDATE";

        	 String tables = "";
        	 String table = "";

        	 // On récupère et met en forme chaque nom de table présentes dans la
        	 // matrice passée en paramètres tout en gérant les doublons
        	 for(String[] line : params)
        	 {
        		 if(line[0] != null)
        		 {
        			 if(line[0].equals(table) == false)
	        		 {
	        			 if(table.equals("") == true)
	        				 tables += line[0];
	        			 else
	        				 tables += ","+line[0];

	        			 table = line[0];
	        		 }
        		 }
        	 }

        	 query += " "+tables+" SET";

        	 int indice = 0;

        	 // On récupère et met en forme chaque nom de champ à modifier et chaque valeur
        	 // qui lui est attribuée en gérant les cases nulles UNIQUEMENT SI ELLES SONT AU DEBUT
        	 for(String[] line : params)
        	 {
        		 indice++;

        		 String tableName = line[0];
        		 String champ = line[1];
        		 String val = line[2];

        		 if(champ != null)
        		 {
	        		 if(indice == params.length)
	        			 query += " "+tableName+"."+champ+"='"+val+"'";
	    			 else
	    				 query += " "+tableName+"."+champ+"='"+val+"',";
        		 }
        	 }

        	 query += " "+where;

            try
            {
                PreparedStatement stat = conn.prepareStatement(query);

                stat.executeQuery("use " + db_name);
                stat.executeUpdate();

                res = true;
            }
            catch(SQLException e)
            {
                System.out.println("sql exception");

                while (e!=null)
                {
                  System.out.println(e.getErrorCode());
                  System.out.println(e.getMessage());
                  System.out.println(e.getSQLState());
                  e.printStackTrace();
                  e=e.getNextException();
                }
                res = false;
            }
            catch(Exception e)
            {
                    e.printStackTrace();
                    res = false;
            }

            // affichage de la requete créée/lancée
            System.out.println(query);
          //  if(!deconnect())
            {
                //probleme de deconnection à la base
            }
        }
        return res;
    } //Update
    public boolean updatebdd(String stable,String val,String swhere )
    {
        boolean res = false;
        String query = "UPDATE "+ stable +" SET " + val + " WHERE "+ swhere;
        System.out.println(query);
        if(connect())
        {    try
            {
        	 	PreparedStatement stat = conn.prepareStatement(query);
                stat.executeUpdate("use " + db_name);
                stat.executeUpdate();
                         	
                res = true;
            }
            catch(SQLException e)
            {
                System.out.println("sql exception");

                while (e!=null)
                {
                  System.out.println(e.getErrorCode());
                  System.out.println(e.getMessage());
                  System.out.println(e.getSQLState());
                  e.printStackTrace();
                  e=e.getNextException();
                }
                res = false;
            }
            catch(Exception e)
            {
                    e.printStackTrace();
                    res = false;
            }
        }    
        return res;
}
    public boolean effaceEnregistrement(String table, String namePrimaryKey, String valPrimaryKey)
    { // efface l'enregistremement a la ligne spécifié par la primary key dans la table spécifiée
        boolean ajout = false;
        if(connect())
        {
            System.out.println("Connexion ok");
            String query = "DELETE FROM " + table+" WHERE "+namePrimaryKey+" = '"+valPrimaryKey+"';";
            System.out.println(query);
            try {
            PreparedStatement stat = conn.prepareStatement(query);

				stat.executeQuery("use " + db_name);
				stat.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
         
        }
    return ajout;
    }
    public int insert(String sRequete,ArrayList<String> asArgument)
    {
        int res = -1;

         if(connect())
        {
            try
            {
                PreparedStatement stat = conn.prepareStatement(sRequete);
                if(asArgument != null)
                {
                    for(int i = 0 ; i < asArgument.size() ;i++)
                    {
                        stat.setString(i+1,asArgument.get(i));
                    }
                }
                stat.executeQuery("use " + db_name);

             //   stat.executeUpdate();
            System.out.println(sRequete);
            stat.executeUpdate(sRequete,Statement.RETURN_GENERATED_KEYS);
            ResultSet res_id = stat.getGeneratedKeys();
            if(res_id.next())
            {
                res = res_id.getInt(1);
                System.out.println(res);

            }
            }
            catch(SQLException e)
            {
                System.out.println("sql exception");

                while (e!=null)
                {
                  System.out.println(e.getErrorCode());
                  System.out.println(e.getMessage());
                  System.out.println(e.getSQLState());
                  e.printStackTrace();
                  e=e.getNextException();
                }
                res = -1;
            }
            catch(Exception e)
            {
                    e.printStackTrace();
                    res = -1;
            }
            if(!deconnect())
            {
                //probleme de deconnection à la base
            }
        }
        return res;
    }
}
