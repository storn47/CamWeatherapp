/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hyacinthe.CamWeather;


import java.awt.Dimension;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

import com.hyacinthe.CamWeather.models.CurrentCamWeather;
import com.hyacinthe.CamWeather.utilies.Alert;
import com.hyacinthe.CamWeather.utilies.Api;
import com.hyacinthe.comtain.AbsoluteConstraints;
import com.hyacinthe.comtain.AbsoluteLayout;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 *
 * @author hyacinthe Dzitouo
 */
public class NewJFrame extends javax.swing.JFrame {

	private static final String GENERIC_ERROR_MESSAGE = "\t\t\t\tOooops!!!\nune erreur est survenue veuillez SVP r�essayer";
	private static final String INTERNET_CONNECTIVITY_ERROR_MESSAGE = "\t\t Oooops!!! \nVeillez verifier l'etat de votre connection!";
	private static final long serialVersionUID = -5855725216852398835L;

	
    public NewJFrame(String title) {
        super(title);
    	
    	initComponents();
		double longitude = -122.4233;
		double latitude = 37.8267;

		System.out.println("avant la requete...");

		// *********** Requte asynchrone ***********

		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder().url(Api.getForecastUrl(latitude, longitude)).build();
		Call call = client.newCall(request);
		call.enqueue(new Callback() {

			@Override
			public void onResponse(Call call, Response response) {
				try (ResponseBody body = response.body()) {
					if (response.isSuccessful()) {
						String jsonData = body.string();
						JSONObject forecast = (JSONObject) JSONValue.parseWithException(jsonData);
						CurrentCamWeather currentCamWeather = new CurrentCamWeather();
						JSONObject currently = (JSONObject) forecast.get("currently");
						
						currentCamWeather.setTimezone((String) forecast.get("timezone"));
						currentCamWeather.setTime((long) currently.get("time"));
						currentCamWeather.setTemperature(Double.parseDouble(currently.get("temperature")+""));
						currentCamWeather.setHumidity(Double.parseDouble(currently.get("humidity") + ""));
						currentCamWeather.setPrecipProbability(Double.parseDouble(currently.get("precipProbability") + ""));
						currentCamWeather.setSummary((String) currently.get("summary"));
						
						jLabel5.setText(currentCamWeather.getTimezone());
						jLabel4.setText(currentCamWeather.getFormattedTime()); 
						jLabel6.setText(currentCamWeather.getTemperature()+"�");
						jLabel10.setText(""+currentCamWeather.getHumidity());
						jLabel12.setText(currentCamWeather.getPrecipProbability()+" %");
						jLabel11.setText(currentCamWeather.getSummary());
						
					} else {
						Alert.error(NewJFrame.this, "ERROR ", GENERIC_ERROR_MESSAGE);
					}
				} catch (ParseException | IOException e) {
					Alert.error(NewJFrame.this, "ERROR ", GENERIC_ERROR_MESSAGE);
				}

			}

			@Override
			public void onFailure(Call call, IOException e) {
				Alert.error(NewJFrame.this, "ERROR", INTERNET_CONNECTIVITY_ERROR_MESSAGE);
			}
		});

		System.out.println("apres la requete.....");

    
    
    
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(114, 70, 223));
        getContentPane().setLayout(new AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(43, 80, 186));
        jPanel1.setLayout(new AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("IL est ");
        jPanel1.add(jLabel1, new AbsoluteConstraints(40, 60, 40, 20));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("et la temperature est de :");
        jPanel1.add(jLabel3, new AbsoluteConstraints(120, 60, 170, 20));

        jLabel4.setBackground(new java.awt.Color(43, 80, 186));
        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("08:10");
        jPanel1.add(jLabel4, new AbsoluteConstraints(80, 60, 40, 20));

        jLabel5.setBackground(new java.awt.Color(43, 80, 186));
        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel5, new AbsoluteConstraints(60, 10, 170, 30));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel6, new AbsoluteConstraints(70, 100, 140, 170));

        jLabel7.setBackground(new java.awt.Color(43, 80, 186));
        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Humidit�");
        jPanel1.add(jLabel7, new AbsoluteConstraints(40, 300, -1, -1));

        jLabel8.setBackground(new java.awt.Color(43, 80, 186));
        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Risque de pluie");
        jPanel1.add(jLabel8, new AbsoluteConstraints(190, 300, 100, -1));
        
        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Perpetua Titling MT", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel10, new AbsoluteConstraints(40, 320, 60, 30));

        jLabel9.setBackground(new java.awt.Color(43, 80, 186));
        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Summary");
        jLabel9.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.add(jLabel9, new AbsoluteConstraints(90, 370, 100, 20));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Perpetua Titling MT", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel11, new AbsoluteConstraints(45, 390, 190, 20));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Perpetua Titling MT", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jLabel12, new AbsoluteConstraints(200, 320, 70, 30));

        getContentPane().add(jPanel1, new AbsoluteConstraints(0, 0, 300, 430));

       
    }
    @Override
	public Dimension getPreferredSize() {
		return new Dimension(305, 457);
	}

	@Override
	public Dimension getMinimumSize() {
		return super.getPreferredSize();
	}

	@Override
	public Dimension getMaximumSize() {
		return getPreferredSize();
	}


    
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    // End of variables declaration//GEN-END:variables
}