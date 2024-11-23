/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Progress;

import java.util.Date;


/**
 *
 * @author ASUS
 */
public class Progress {
    
    private Date dateOfStart ;
    private Boolean isCompleted;
    private Date dateOfEnd ;
    private double prercentOfAchv;

    public Progress(Date dateOfStart) {
        this.dateOfStart = dateOfStart;
    }

    public Date getDateOfStart() {
        return dateOfStart;
    }

    public void setDateOfStart(Date dateOfStart) {
        this.dateOfStart = dateOfStart;
    }

    public Boolean getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(Boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public Date getDateOfEnd() {
        return dateOfEnd;
    }

    public void setDateOfEnd(Date dateOfEnd) {
        this.dateOfEnd = dateOfEnd;
    }

    public double getPrercentOfAchv() {
        return prercentOfAchv;
    }

    public void setPrercentOfAchv(double prercentOfAchv) {
        this.prercentOfAchv = prercentOfAchv;
    }
    
    
    
    
    
}
