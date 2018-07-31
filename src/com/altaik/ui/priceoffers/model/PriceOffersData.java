/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.altaik.ui.priceoffers.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Aset
 */
public class PriceOffersData {
    
    public static final String LOT_NUMBER = "lotNumber";
    public static final String OFFER_SUM = "offerSum";
    public static final String LOTS_PRICES = "lotsPrices";
    public static final String AUTH_PATH = "authPath";
    public static final String GOS_PATH = "gosPath";
    public static final String AUTH_PASS = "authPass";
    public static final String GOS_PASS = "gosPass";
    public static final String AUTH_TYPE = "authType";
    public static final String JKS_PATH = "jksPath";
    public static final String JKS_PASS = "jksPass";
    public static final String ZAKUP_PASS = "zakupPass";
    
    private final StringProperty lotNumber;
    private final StringProperty lotsPrices;
    private final DoubleProperty offerSum;
    private final StringProperty authPath;
    private final StringProperty gosPath;
    private final StringProperty authPass;
    private final StringProperty gosPass;
    private final StringProperty authType;
    private final StringProperty jksPath;
    private final StringProperty jksPass;
    private final StringProperty zakupPass;
    
    
    public PriceOffersData() {
        lotNumber = new SimpleStringProperty(this,LOT_NUMBER,"");
        offerSum = new SimpleDoubleProperty(this, OFFER_SUM, 1000000.00);
        lotsPrices = new SimpleStringProperty(this, LOTS_PRICES, "1000000");
        authPath = new SimpleStringProperty(this, AUTH_PATH, "");
        gosPath = new SimpleStringProperty(this, GOS_PATH, "");
        authPass = new SimpleStringProperty(this, AUTH_PASS, "123456");
        gosPass = new SimpleStringProperty(this, GOS_PASS, "123456");
        authType = new SimpleStringProperty(this, AUTH_TYPE, "pkcs12");
        jksPath = new SimpleStringProperty(this, JKS_PATH, "D:\\aset\\ecp\\oebs.gos.jks");
        jksPass = new SimpleStringProperty(this, JKS_PASS, "3075341");
        zakupPass = new SimpleStringProperty(this, ZAKUP_PASS, "123456");
    }
    
    
    public final String getLotsPrices() {
        return lotsPrices.get();
    }
    
    public final void setLotsPrices(String value) {
        lotsPrices.set(value);
    }
    
    public StringProperty lotsPricesProperty(){
        return lotsPrices;
    }
    
    
    public final String getZakupPass() {
        return zakupPass.get();
    }
    
    public final void setZakupPass(String value) {
        zakupPass.set(value);
    }
    
    public StringProperty zakupPassProperty(){
        return zakupPass;
    }
    
    
    public final String getJksPath() {
        return jksPath.get();
    }
    
    public final void setJksPath(String value) {
        jksPath.set(value);
    }
    
    public StringProperty jksPathProperty(){
        return jksPath;
    }
    
    
    public final String getJksPass() {
        return jksPass.get();
    }
    
    public final void setJksPass(String value) {
        jksPass.set(value);
    }
    
    public StringProperty jksPassProperty(){
        return jksPass;
    }
    
    
    public final String getAuthType() {
        return authType.get();
    }
    
    public final void setAuthType(String value) {
        authType.set(value);
    }
    
    public StringProperty authTypeProperty(){
        return authType;
    }
    
    
    public final String getLotNumber() {
        return lotNumber.get();
    }
    
    public final void setLotNumber(String value) {
        lotNumber.set(value);
    }
    
    public StringProperty lotNumberProperty(){
        return lotNumber;
    }
    
    
    public final Double getOfferSum() {
        return offerSum.get();
    }
    
    public final void setOfferSum(Double value) {
        offerSum.set(value);
    }
    
    public DoubleProperty offerSumProperty(){
        return offerSum;
    }
    
    
    public final String getAuthPath() {
        return authPath.get();
    }
    
    public final void setAuthPath(String value) {
        authPath.set(value);
    }
    
    public StringProperty authPathProperty(){
        return authPath;
    }
    
    
    public final String getGosPath() {
        return gosPath.get();
    }
    
    public final void setGosPath(String value) {
        gosPath.set(value);
    }
    
    public StringProperty gosPathProperty(){
        return gosPath;
    }
    
    
    public final String getAuthPass() {
        return authPass.get();
    }
    
    public final void setAuthPass(String value) {
        authPass.set(value);
    }
    
    public StringProperty authPassProperty(){
        return authPass;
    }
    
    
    public final String getGosPass() {
        return gosPass.get();
    }
    
    public final void setGosPass(String value) {
        gosPass.set(value);
    }
    
    public StringProperty gosPassProperty(){
        return gosPass;
    }
    
}
