package io.github.tundraclimate.coldlib.database.sqlite

import io.github.tundraclimate.coldlib.ColdLib
import java.sql.*

class SQLite(private val dbname: String) {
    private lateinit var connect: Connection
    private lateinit var state: Statement
    private var preState: PreparedStatement? = null

    fun connectSQLite() {
        try {
            Class.forName("org.sqlite.JDBC")
            if (!ColdLib.plugin.dataFolder.exists()) ColdLib.plugin.dataFolder.mkdirs()
            connect = DriverManager.getConnection("jdbc:sqlite:" + ".\\plugins\\" + ColdLib.plugin.name + "\\" + dbname)
            state = connect.createStatement()
        } catch (e: SQLException) {
            e.printStackTrace()
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
        }
    }

    fun executeUpdate(sql: String) {
        state.executeUpdate(sql)
    }

    fun executeQuery(sql: String): ResultSet {
        return state.executeQuery(sql)
    }

    fun prepareStatement(sql: String): PreparedStatement {
        return connect.prepareStatement(sql).also { preState = it }
    }

    fun hasTable(table: String): Boolean {
        try {
            val rs = state.executeQuery(
                "SELECT COUNT(*) FROM sqlite_master WHERE TYPE='table' AND name='$table'"
            )
            if (rs.getInt(1) != 0) return true
        } catch (e: SQLException) {
            e.printStackTrace()
        }
        return false
    }

    fun containValue(table: String, column: String, value: String): Boolean {
        var bool = false
        try {
            val rs = state.executeQuery(
                "SELECT COUNT(*) FROM $table WHERE $column ='$value'"
            )
            bool = rs.getInt(1) != 0
        } catch (e: SQLException) {
            e.printStackTrace()
        }
        return bool
    }


    fun disconnectSQLite() {
        try {
            connect.close()
            state.close()
            if (preState != null) {
                preState!!.close()
            }
        } catch (e: SQLException) {
            e.printStackTrace()
        }
    }
}