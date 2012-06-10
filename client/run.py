#!/usr/bin/python -d

import sys
from PyQt4 import QtCore, QtGui
from forms.home_screen_widget import Ui_Form as HomeScreenWidgetUi
from forms.main_window import Ui_MainWindow as MainWindowUi
# from controller import Controller


class HomeScreenWidget(QtGui.QWidget):
    def __init__(self, parent=None):
        super(HomeScreenWidget, self).__init__(parent)
        self.ui = HomeScreenWidgetUi()
        self.ui.setupUi(self)
        QtCore.QObject.connect(self.ui.backupButton,
            QtCore.SIGNAL("clicked()"), parent.demo_action)


class MainWindow(QtGui.QMainWindow):
    def __init__(self, parent=None):
        QtGui.QWidget.__init__(self, parent)
        # super(MainWindow, self).__init__(parent)
        self.ui = MainWindowUi()
        self.ui.setupUi(self)
        centralWidget = HomeScreenWidget(self)
        self.setCentralWidget(centralWidget)

        """
        QWidget *firstPageWidget = new QWidget;
        QWidget *secondPageWidget = new QWidget;
        QWidget *thirdPageWidget = new QWidget;

        QStackedLayout *stackedLayout = new QStackedLayout;
        stackedLayout->addWidget(firstPageWidget);
        stackedLayout->addWidget(secondPageWidget);
        stackedLayout->addWidget(thirdPageWidget);

        QVBoxLayout *mainLayout = new QVBoxLayout;
        mainLayout->addLayout(stackedLayout);
        setLayout(mainLayout);
        """

    def setMainWidget(self):
        self.scrollLayout.addRow(Test())

    def demo_action(self):
        print("demo")


if __name__ == "__main__":
    app = QtGui.QApplication(sys.argv)
    myapp = MainWindow()
    myapp.show()
    sys.exit(app.exec_())
