#!/usr/bin/python -d

import sys
from PyQt4 import QtCore, QtGui
from forms.homeScreenWidget import Ui_Form
# from controller import Controller


class MyForm(QtGui.QWidget):
    def __init__(self, parent=None):
        QtGui.QWidget.__init__(self, parent)
        self.ui = Ui_Form()
        self.ui.setupUi(self)
        QtCore.QObject.connect(self.ui.backupButton,
            QtCore.SIGNAL("clicked()"), self.demo_action)

    def demo_action(self):
        print("demo")


if __name__ == "__main__":
    app = QtGui.QApplication(sys.argv)
    myapp = MyForm()
    myapp.show()
    sys.exit(app.exec_())
