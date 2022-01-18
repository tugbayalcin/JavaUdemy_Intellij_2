package Section10_Abstract_Interface_Inner.modifiers.accessModifiers;

public class ProtectedKeywordKullanimi
{
    // paket disindan erisim saglamayi saglar
    // paket disindaki bir sinif protected elemanlari olan classimdan extend edildiginde protected elemanlara erisebiliyor
    // yalnizca kalitim aldiginda erisebilir
    // yani classtan obje olusturup obje. ile erisemem sadece sout yapisi gibi kodlarin icinde kullanabilirim
    // classlar protected tanimlanamazlar
    protected int protectedDegisken;
    protected void protectedMethod(){}
    protected class InnerProtectedClass{}
    // protected elemanlara erismenin 2 yolu vardir
    // 1. ayni package icinde olmamk
    // 2. kalitim almak // bu ozellik ile default classtan ayrilir, default class baska package icinden kalitilamaz
    public class disClass{
        protected class innerClass{} // inner classlar protected olabilir
    }
}




