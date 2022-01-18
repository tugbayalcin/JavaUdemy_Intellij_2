package Section11_Generic_Package_Jar.Packages;

import java.awt.*; // java.package adi ile package in icine girdik. noktaya bastigimiz anda pacage icindekiler onumuze dokuldu
// eger ben package icindeki (inner package olmayan) elemanlarin tumune erismek istiyorsam * koyarim,
// bir tane classa erismek istiyorsam onun adini yazarim, package icindeki package a erismek istiyorsam
// java.packageName.innerPackageName.*;  yazarim
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyWindow extends Frame
{
    public MyWindow(String title)
    {
        super(title);
        setSize(500,300);
        addWindowListener(new WindowAdapter() {
            @Override // anonymous inner class ornegi
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Font sansSerif = new Font("SansSerif", Font.BOLD,18);
        g.setFont(sansSerif);
        g.drawString("JAVA DERSLERİ",185,150);

        Font sansSerifKucuk = new Font("SansSerif", Font.BOLD,12);
        g.setFont(sansSerifKucuk);
        g.drawString("by tugbayalcin",208,175);
    }
}
