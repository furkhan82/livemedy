Feature:Smoke

  Scenario: Kullanici dogru kullanici adi ve dogru sifre ile sisteme girer
    #Given VPN Manager ac

    Given Kullanici livemedy ana sayfasini browserdan acar
    Then Kullanici login butonuna tiklar
    And Kullanici dogru email girer
    Then Kullanici dogru sifre girer
    And Kullanici Oturum acin butonuna tiklar
    Then Kullanici acilan popup varsa kapatir
    And Kullanici sms dogrulama kodunu girer ve tamam butonuna tiklar
    And Kullanıcı logout yapar
    #Then Kullanici browseri kapatir



  Scenario: Kullanici dogru kullanici adi ve yanlis sifre ile sisteme giremez
   # Given Kullanici livemedy ana sayfasini browserdan acar
    Then Kullanici login butonuna tiklar
    And Kullanici dogru email girer
    Then Kullanici yanlis sifre girer
    And Kullanici Oturum acin butonuna tiklar
    Then Kullanici sifrenin yanlis oldugunu dogrular
    Then Kullanici acilan popup varsa kapatir
    And Kullanici browseri kapatir



