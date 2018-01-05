package com.watiapp.watiapp.dao;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.watiapp.watiapp.model.Cigarro;
import com.watiapp.watiapp.model.TarefaDesafio;
import com.watiapp.watiapp.model.TarefaDica;
import com.watiapp.watiapp.model.Usuario;
import com.j256.ormlite.dao.Dao;

public class DBSQLite extends OrmLiteSqliteOpenHelper {

    private Dao<Usuario, Integer> usuarioDao;
    private Dao<Cigarro, Integer> cigarroDao;
    private Dao<TarefaDesafio, Integer> desafioDao;
    private Dao<TarefaDica, Integer> dicaDao;

    public DBSQLite(Context context, String DB_NAME, int DB_VERSION) {
        super(context, DB_NAME, null, DB_VERSION);
        getWritableDatabase();
    }


    public void onCreate(SQLiteDatabase sqliteDatabase, ConnectionSource connectionSource) {
        try {

            TableUtils.createTable(connectionSource, Usuario.class);
            TableUtils.createTable(connectionSource, Cigarro.class);
            TableUtils.createTable(connectionSource, TarefaDesafio.class);
            TableUtils.createTable(connectionSource, TarefaDica.class);

        } catch (SQLException e) {
            Log.e(DBSQLite.class.getName(), "Unable to create datbases", e);
            Log.e(DBSQLite.class.getName(), "Erro na criação do bano de dados");
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
            Log.e(DBSQLite.class.getName(), "Erro na criação do bano de dados");
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource cs, int oldVersion, int newVersion) {
        try {

            // In case of change in database of next version of application, please increase the value of DATABASE_VERSION variable, then this method will be invoked
            //automatically. Developer needs to handle the upgrade logic here, i.e. create a new table or a new column to an existing table, take the backups of the
            // existing database etc.

            TableUtils.dropTable(connectionSource, Usuario.class, true);
            TableUtils.dropTable(connectionSource, Cigarro.class, true);
            TableUtils.dropTable(connectionSource, TarefaDesafio.class, true);
            TableUtils.dropTable(connectionSource, TarefaDica.class, true);
            onCreate(db, connectionSource);

        } catch (SQLException e) {
            Log.e(DBSQLite.class.getName(), "Unable to upgrade database from version " + oldVersion + " to new "
                    + newVersion, e);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }

    public void close(){
        super.close();
    }

    public Dao<Usuario, Integer> getUserDao() throws SQLException, java.sql.SQLException {
        if (usuarioDao == null){
            usuarioDao = getDao(Usuario.class);
        }
        return usuarioDao;
    }

    public Dao<Cigarro, Integer> getCigarroDao() throws SQLException, java.sql.SQLException {
        if (cigarroDao == null){
            cigarroDao = getDao(Cigarro.class);
        }
        return cigarroDao;
    }

    public Dao<TarefaDesafio, Integer> getDesafioDao() throws SQLException, java.sql.SQLException {
        if (desafioDao == null){
            desafioDao = getDao(TarefaDesafio.class);
        }
        return desafioDao;
    }

    public Dao<TarefaDica, Integer> getDicasDao() throws SQLException, java.sql.SQLException {
        if (dicaDao == null){
            dicaDao = getDao(TarefaDica.class);
        }
        return dicaDao;
    }

}



