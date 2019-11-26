/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import javax.sql.DataSource;
import modele.entity.ClientEntity;

/**
 *
 * @author Axel
 */
public class DAOclient {
    
    
    private final DataSource myDataSource;

	/**
	 * Construit le AO avec sa source de données
	 * @param dataSource la source de données à utiliser
	 */
	public DAOclient(DataSource dataSource) {
		this.myDataSource = dataSource;
	}
        
        /**
         * @return Liste de ClientsEntity
         * @throws SQLException 
         */
        public List<ClientEntity> tousLesClients() throws SQLException{
            List<ClientEntity> result = new LinkedList<>();

		String sql = "SELECT * FROM CLIENT";
		try (Connection connection = myDataSource.getConnection();
                     PreparedStatement stmt = connection.prepareStatement(sql)) {
                        ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
                            String code = rs.getString("CODE");
                            String societe = rs.getString("SOCIETE");
                            String contact = rs.getString("CONTACT");
                            String fonction = rs.getString("FONCTION");
                            String adresse = rs.getString("ADRESSE");
                            String ville = rs.getString("VILLE");
                            String region = rs.getString("REGION");
                            String code_postal = rs.getString("CODE_POSTAL");
                            String pays = rs.getString("PAYS");
                            String telephone = rs.getString("TELEPHONE");
                            String fax = rs.getString("FAX");
                            ClientEntity c = new ClientEntity(code,societe,contact,fonction,adresse,ville,region,code_postal,pays,telephone,fax);
                            result.add(c);
			}
		}
		return result;
        }
        
        /**
         * Permet d'afficher un client dans la BDD
         * @param code clef primaire d'un client
         * @return le client sous la forme ClientEntity
         */
        public ClientEntity afficherClient(String code){
            //TODO
            return null;
        }
        
        /**
         * Modifie le nom de la société d'un client
         * @param client le code du client à modifier
         * @param societe le nouveau nom de la societe
         */
        public void modifierSociete(String client, String societe){
            //TODO
        }
        
        /**
         * Modifie le contact d'un client
         * @param client le code du client à modifier
         * @param contact le nouveau contact du client
         */
        public void modifierContact(String client, String contact){
            //TODO
        }
        
        /**
         * Modifie la fonction d'un client
         * @param client le code du client à modifier
         * @param fonction le nouveau contact d'un client
         */
        public void modifierFonction(String client, String fonction){
            //TODO
        }
        /**
         * Modifie l'adresse d'un client
         * @param client le code du client à modifier
         * @param adresse la nouvelle adresse du client
         */
        public void modifierAdresse(String client, String adresse){
            //TODO
        }
        /**
         * Modifie la ville du client
         * @param client le code du client à modifier
         * @param ville la nouvelle ville du client
         */
        public void modifierVille(String client, String ville){
            //TODO
        }
        
        /**
         * Modifie la région du client
         * @param client le code du client à modifier
         * @param region la nouvelle région du client
         */
        public void modifierRegion(String client, String region){
            //TODO
        }
        
        /**
         * Modifie le code postal d'un client
         * @param client le code du client à modifier
         * @param CodePostal le nouveau code postal du client
         */
        public void modifierCodePostal(String client, String CodePostal){
            //TODO
        }
        
        /**
         * Modifie le pays d'un client
         * @param client le code du client à modifier
         * @param pays le nouveau pays du client
         */
        public void modifierPays(String client, String pays){
            //TODO
        }
        
        /**
         * Modifie le numéro de téléphone du client
         * @param client le code du client à modifier
         * @param telephone le nouveau numéro de téléphone
         */
        public void modifierTelephone(String client, String telephone){
            //TODO
        }
        
        /**
         * Modifie le fax d'un client
         * @param client le code du client à modifier
         * @param fax le nouveau numéro de fax
         */
        public void modifierFax(String client, String fax){
            //TODO
        }
    
}