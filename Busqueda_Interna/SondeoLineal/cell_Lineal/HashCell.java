/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hashtable;


class HashCell {
    int key;
    String value;
    boolean isDeleted;

    public HashCell(int key, String value) {
        this.key = key;
        this.value = value;
        this.isDeleted = false;
    }
}

