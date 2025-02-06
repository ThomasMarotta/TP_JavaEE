package org.iut.montreuil.DAO;

import org.iut.montreuil.bean.Annonce;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AnnonceDAO extends DAO<Annonce> {
    public AnnonceDAO(Connection con) {
        super(con);
    }

    @Override
    public Boolean create(Annonce object) {
        try {
            PreparedStatement ps = this.con.prepareStatement("INSERT INTO public.annonces (title, description, adress, mail) VALUES (?,?,?,?)");

            ps.setString(1, object.getTitre());
            ps.setString(2, object.getDescription());
            ps.setString(3, object.getAdresse());
            ps.setString(4, object.getEmail());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public Boolean update(Annonce object) {
        try {
            PreparedStatement ps = this.con.prepareStatement("UPDATE public.annonces SET title = ?, description = ?, adress = ?, mail = ? WHERE annoncesid = ?");
            ps.setString(1, object.getTitre());
            ps.setString(2, object.getDescription());
            ps.setString(3, object.getAdresse());
            ps.setString(4, object.getEmail());
            ps.setInt(5, object.getId());

            int i = ps.executeUpdate();

            return i > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Boolean delete(int id) {
        int i = 0;
        try {
            PreparedStatement ps = this.con.prepareStatement("DELETE FROM annonces WHERE annoncesid = ?");
            ps.setInt(1, id);
             i = ps.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        }
        return i > 0;
    }

    @Override
    public Annonce find(int id) {
        Annonce annonce = null;
        try {
            PreparedStatement ps = this.con.prepareStatement("SELECT * FROM public.annonces WHERE annoncesid = ?");
            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();

            if(result.next()){
                annonce = new Annonce(result.getInt("annoncesid"),
                        result.getString("title"),
                        result.getString("description"),
                        result.getString("adress"),
                        result.getString("mail"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return annonce;
    }

    @Override
    public ArrayList<Annonce> findAll() {
        ArrayList<Annonce> annonces = new ArrayList<>();
        try {
            PreparedStatement ps = this.con.prepareStatement("SELECT * FROM public.annonces");

            ResultSet result = ps.executeQuery();

            while (result.next()) {
                Annonce annonce = new Annonce(result.getInt("annoncesid"),
                        result.getString("title"),
                        result.getString("description"),
                        result.getString("adress"),
                        result.getString("mail"));

                annonces.add(annonce);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return annonces;
    }
}
