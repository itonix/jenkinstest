/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import modele.dao.DAOclient;
import modele.entity.ClientEntity;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import org.hsqldb.cmdline.SqlFile;
import org.hsqldb.cmdline.SqlToolError;
import org.junit.After;

/**
 *
 * @author Axel
 */
public class DAOclientTest {
    
    private DAOclient dao; // L'objet à tester
    private DataSource myDataSource; // La source de données à utiliser
    private static Connection myConnection ;
    private String code; //Le code client qu'on utilise dans les jeux de tests
	

    @Before
    public void setUp() throws SQLException, IOException, SqlToolError {
        myDataSource = getDataSource();
	myConnection = myDataSource.getConnection();
	// On initialise la base avec le contenu d'un fichier de test
	String sqlFilePath = DAOclientTest.class.getResource("database.sql").getFile();
	SqlFile sqlFile = new SqlFile(new File(sqlFilePath));
	sqlFile.setConnection(myConnection);
	sqlFile.execute();
	sqlFile.closeReader();	
	// On crée l'objet à tester
	dao = new DAOclient(myDataSource);
        code = "ALFKI";
    }
    
    @After
    public void tearDown() throws SQLException {
        myConnection.close();		
        dao = null; // Pas vraiment utile
    }
    
    /**
     * Teste la méthode tousLesClients
     * @throws SQLException 
     */
    @Test
    public void testToutLesClientsTest() throws SQLException {
        List<ClientEntity> listeclients = dao.tousLesClients();
        assertEquals(91,listeclients.size());
    }
    
    /**
     * teste la méthode afficherClient
     * @throws SQLException 
     */
    @Ignore
    @Test
    public void afficherClientTest() throws SQLException {
        ClientEntity client = new ClientEntity("ALFKI", "Alfreds Futterkiste", "Maria Anders", "Représentant(e)", "Obere Str. 57", "Berlin", null, "12209", "Allemagne", "030-0074321", "030-0076545");
        assertEquals(client,dao.afficherClient(code));
    }
    
    /**
     * teste la méthode modifierSociete
     * @throws SQLException 
     */
    @Ignore
    @Test
    public void modifierSocieteTest() throws SQLException{
        String ancien = dao.afficherClient(code).getSociete();
        String nouveau = "Université Champollion";
        dao.modifierSociete(code,nouveau);
        ClientEntity client = dao.afficherClient(code);
        assertEquals(nouveau,client.getSociete());
        dao.modifierSociete(code,ancien);
    }
    
    /**
     * teste la méthode modifierContact
     * @throws SQLException 
     */
    @Ignore
    @Test
    public void modifierContactTest() throws SQLException{
        String ancien = dao.afficherClient(code).getContact();
        String nouveau = "Dupont Dupond";
        dao.modifierContact(code, nouveau);
        ClientEntity client = dao.afficherClient(code);
        assertEquals(nouveau,client.getContact());
        dao.modifierContact(code,ancien);
    }
    
    /**
     * teste la méthode modifierFonction
     * @throws SQLException 
     */
    @Ignore
    @Test
    public void modifierFonctionTest() throws SQLException{
        String ancien = dao.afficherClient(code).getFonction();
        String nouveau = "Directeur";
        dao.modifierFonction(code, nouveau);
        ClientEntity client = dao.afficherClient(code);
        assertEquals(nouveau,client.getFonction());
        dao.modifierFonction(code, ancien);
    }
    
    /**
     * teste la méthode modifierAdresse
     * @throws SQLException 
     */
    @Ignore
    @Test
    public void modifierAdresseTest() throws SQLException{
        String ancien = dao.afficherClient(code).getAdresse();
        String nouveau = "15 rue machin";
        dao.modifierAdresse(code, nouveau);
        ClientEntity client = dao.afficherClient(code);
        assertEquals(nouveau,client.getAdresse());
        dao.modifierAdresse(code, ancien);
    }
    
    /**
     * Test méthode modifierVille
     * @throws SQLException 
     */
    @Ignore
    @Test
    public void modifierVilleTest() throws SQLException{
        String ancien = dao.afficherClient(code).getVille();
        String nouveau = "Albi";
        dao.modifierVille(code, nouveau);
        ClientEntity client = dao.afficherClient(code);
        assertEquals(nouveau,client.getVille());
        dao.modifierVille(code, ancien);
    }
    
    /**
     * Test méthode modifierRégion
     * @throws SQLException 
     */
    @Ignore
    @Test
    public void modifierRegionTest() throws SQLException{
        String ancien = dao.afficherClient(code).getRegion();
        String nouveau = "Tarn";
        dao.modifierRegion(code,nouveau);
        ClientEntity client = dao.afficherClient(code);
        assertEquals(nouveau,client.getRegion());
        dao.modifierRegion(code, ancien);
    }
    
    /**
     * Teste méthode modifierCodePostal
     * @throws SQLException 
     */
    @Ignore
    @Test
    public void modifierCodePostalTest() throws SQLException{
        String ancien = dao.afficherClient(code).getCode_postal();
        String nouveau = "81380";
        dao.modifierCodePostal(code, nouveau);
        ClientEntity client = dao.afficherClient(code);
        assertEquals(nouveau,client.getCode_postal());
        dao.modifierCodePostal(code, ancien);
    }
    /**
     * Test méthode modifierVille
     * @throws SQLException 
     */
    @Ignore
    @Test
    public void modifierPaysTest() throws SQLException{
        String ancien = dao.afficherClient(code).getPays();
        String nouveau = "France";
        dao.modifierPays(code, nouveau);
        ClientEntity client = dao.afficherClient(code);
        assertEquals(nouveau,client.getPays());
        dao.modifierPays(code, ancien);
    }
    
    /**
     * Test méthode modifierTelephone
     * @throws SQLException 
     */
    @Ignore
    @Test
    public void modifierTelephoneTest() throws SQLException{
        String ancien = dao.afficherClient(code).getPays();
        String nouveau = "0102030405";
        dao.modifierTelephone(code, nouveau);
        ClientEntity client = dao.afficherClient(code);
        assertEquals(nouveau,client.getTelephone());
        dao.modifierTelephone(code, ancien);
    }
    
    /**
     * Teste méthode modifierFax
     * @throws SQLException 
     */
    @Ignore
    @Test
    public void modifierFaxTest() throws SQLException{
        String ancien = dao.afficherClient(code).getFax();
        String nouveau = "0102030405";
        dao.modifierFax(code, nouveau);
        ClientEntity client = dao.afficherClient(code);
        assertEquals(nouveau,client.getFax());
        dao.modifierFax(code,ancien);
    }   
    
    
    public static DataSource getDataSource() throws SQLException {
		org.hsqldb.jdbc.JDBCDataSource ds = new org.hsqldb.jdbc.JDBCDataSource();
		ds.setDatabase("jdbc:hsqldb:mem:testcase;shutdown=true");
		ds.setUser("sa");
		ds.setPassword("sa");
		return ds;
	}
}