tags:
Exception in thread "AWT-EventQueue-0" java.lang.NullPointerException
	at com.mysql.jdbc.UpdatableResultSet.syncUpdate(UpdatableResultSet.java:1550)
	at com.mysql.jdbc.UpdatableResultSet.updateString(UpdatableResultSet.java:2490)
	at hotel.TamuJFrame_TabelModel.editButtonActionPerformed(TamuJFrame_TabelModel.java:314)
	at hotel.TamuJFrame_TabelModel.access$100(TamuJFrame_TabelModel.java:13)
	at hotel.TamuJFrame_TabelModel$2.actionPerformed(TamuJFrame_TabelModel.java:171)
...
...
...
