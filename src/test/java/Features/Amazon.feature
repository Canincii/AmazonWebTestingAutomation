@Amazon
  Feature:Amazon.com
    Scenario:Amazonda sepete ürün ekleme
      Given Kullanici anasayfada olur
      When Popup kabul eder
      When Arama textine tiklar
      When Urun adini girer
      When Arama butonuna tiklar
      When Kargo secenegini butonuna tiklar
      When Dört yildiz ve üzerini secer
      When Urune tiklar
      When Olcü secilir
      When Sepete ekle butonuna tiklanir
      When Sepete git butonuna tiklanir
      Then Sepette ürün kontrol edilir

