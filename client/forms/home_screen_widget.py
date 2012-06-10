# -*- coding: utf-8 -*-

# Form implementation generated from reading ui file 'home_screen_widget.ui'
#
# Created: Mon Jun 11 00:01:05 2012
#      by: PyQt4 UI code generator 4.9.1
#
# WARNING! All changes made in this file will be lost!

from PyQt4 import QtCore, QtGui

try:
    _fromUtf8 = QtCore.QString.fromUtf8
except AttributeError:
    _fromUtf8 = lambda s: s

class Ui_Form(object):
    def setupUi(self, Form):
        Form.setObjectName(_fromUtf8("Form"))
        Form.resize(400, 300)
        self.gridLayoutWidget = QtGui.QWidget(Form)
        self.gridLayoutWidget.setGeometry(QtCore.QRect(100, 70, 231, 171))
        self.gridLayoutWidget.setObjectName(_fromUtf8("gridLayoutWidget"))
        self.gridLayout = QtGui.QGridLayout(self.gridLayoutWidget)
        self.gridLayout.setMargin(0)
        self.gridLayout.setObjectName(_fromUtf8("gridLayout"))
        self.backupButton = QtGui.QPushButton(self.gridLayoutWidget)
        self.backupButton.setObjectName(_fromUtf8("backupButton"))
        self.gridLayout.addWidget(self.backupButton, 0, 0, 1, 1)
        self.restoreButton = QtGui.QPushButton(self.gridLayoutWidget)
        self.restoreButton.setObjectName(_fromUtf8("restoreButton"))
        self.gridLayout.addWidget(self.restoreButton, 1, 0, 1, 1)

        self.retranslateUi(Form)
        QtCore.QMetaObject.connectSlotsByName(Form)

    def retranslateUi(self, Form):
        Form.setWindowTitle(QtGui.QApplication.translate("Form", "Form", None, QtGui.QApplication.UnicodeUTF8))
        self.backupButton.setText(QtGui.QApplication.translate("Form", "Back-Up", None, QtGui.QApplication.UnicodeUTF8))
        self.restoreButton.setText(QtGui.QApplication.translate("Form", "Restore", None, QtGui.QApplication.UnicodeUTF8))


if __name__ == "__main__":
    import sys
    app = QtGui.QApplication(sys.argv)
    Form = QtGui.QWidget()
    ui = Ui_Form()
    ui.setupUi(Form)
    Form.show()
    sys.exit(app.exec_())

