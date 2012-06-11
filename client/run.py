#!/usr/bin/python -d

import sys
from PyQt4 import QtCore, QtGui
from forms.home_screen_widget import Ui_Form as HomeScreenWidgetUi
from forms.restore_widget import Ui_Form as RestoreWidgetUi
from forms.main_window import Ui_MainWindow as MainWindowUi


class RestoreWidget(QtGui.QWidget):
    def __init__(self, parent=None):
        super(RestoreWidget, self).__init__(parent)
        self.ui = RestoreWidgetUi()
        self.ui.setupUi(self)
        self.set_up_signals_slots()
        self.fill_up_listbox()

    def set_up_signals_slots(self):
        QtCore.QObject.connect(self.ui.downloadButton,
            QtCore.SIGNAL("clicked()"), self.download_selected_items)


    def fill_up_listbox(self):
        items = [
            "Ubuntu-desktop.ISO",
            "Ubuntu-server.ISO",
            "BT5R2.ISO",
            "install-amd64-min.ISO",
        ]
        for item in items:
            QtGui.QListWidgetItem(item, self.ui.remoteListWidget);

    def download_selected_items(self):
        selected_items = self.ui.remoteListWidget.selectedItems()
        for item in selected_items:
            cloned_item = item.clone()
            self.ui.localListWidget.addItem(cloned_item)



class HomeScreenWidget(QtGui.QWidget):
    def __init__(self, parent=None):
        super(HomeScreenWidget, self).__init__(parent)
        self.ui = HomeScreenWidgetUi()
        self.ui.setupUi(self)
        QtCore.QObject.connect(self.ui.backupButton,
            QtCore.SIGNAL("clicked()"), parent.show_back_up_widget)
        QtCore.QObject.connect(self.ui.restoreButton,
            QtCore.SIGNAL("clicked()"), parent.show_restore_widget)


class MainWindow(QtGui.QMainWindow):
    def __init__(self, parent=None):
        QtGui.QWidget.__init__(self, parent)
        # super(MainWindow, self).__init__(parent)
        self.ui = MainWindowUi()
        self.ui.setupUi(self)
        centralWidget = HomeScreenWidget(self)
        self.setCentralWidget(centralWidget)

    def demo_action(self):
        print("demo")

    def show_back_up_widget(self):
        print("TODO")

    def show_restore_widget(self):
        print("TODO")
        restore_widget = RestoreWidget(self)
        self.setCentralWidget(restore_widget)


if __name__ == "__main__":
    app = QtGui.QApplication(sys.argv)
    myapp = MainWindow()
    myapp.show()
    sys.exit(app.exec_())
