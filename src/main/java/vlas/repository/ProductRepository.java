package vlas.repository;

import vlas.entity.Users;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRepository extends AbstractRepository{




    @Override
    protected String getTableName() {
        return "product";
    }

    @Override
    protected Product mapResultSetToEntity(ResultSet rs) throws SQLException {
        Users users = new Users(rs.getInt(1),rs.getString(2), rs.getString(3),
                rs.getInt(4), rs.getString(5), rs.getString(6));
        return users;
    }
}
