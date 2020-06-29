# Documentation
Dokumentation von Livio Luna und Nico Tuscano aus der Klasse 5ia17a zum Abschlussprojekt "Password Safe"
im Modul 122 von Rinaldo Lanza.

## Login
Diese Applikation beinhaltet einen fixen user:
Login: user
Passwort: secret123

## Reflexion Livio
Die Zusammenarbeit mit Herrn Tuscano hat mir sehr gefallen, da wir uns auch so super verstehen. 
Die Arbeiten haben wir meiner Meinung nach gut und so genau wie wir konnten gelöst. 
Einige Feature Ideen die wir hatten konnten wir leider nicht umsetzen, da die Zeit etwas knapp war 
(eine dieser Ideen wäre zum Beispiel eine Bearbeitungs Seite zu erstellen um die bereits vorhanden Einträge der Password-List zu Editieren). 
 
Dementsprechend würden wir uns das nächste mal strikter an den Zeitplan halten und die Aufgaben immer dann Erledigen, 
wenn wir für uns die Deadline gesetzt haben. Die Kommunikation im Team war sehr gut und auch regelmässig, 
wir hatten immer einen Überblick über die Arbeiten welche wir erreichen mussten um ans Ziel zu kommen. 
 
Auch wenn es einige Schwierigkeiten auf unserem Weg gab, wie zum Beispiel das mein Git Bash nicht richtig funktionierte 
wegen den Berechtigungen, haben wir uns immer gegenseitig geholfen um die Probleme zu minimieren.

## Reflexion Nico
Die Zusammenarbeit mit Herr Luna hat mir sehr gefallen, wir haben gut im Team zusammengearbeitet.
Jeder hat immer gewusst was er zu tun hatte und hat dies auch immer umgesetzt. Die Kommunikation lief gut, 
wir haben uns immer wieder Online getroffen um den aktuellen Stand zu besprechen und haben falls nötig dann zusammen an Problemen gearbeitet. 
 
Was nicht so gut lief war die Planung, wir haben uns keine Gedanken gemacht, was wir denn nun alles umsetzen wollen
und haben so gegen Ende den Überblick verloren, wie viel Zeit wir noch für alles haben. So haben wir nun nicht alles umgesetzt
was wir usprünglich auch wollten.
Ebenso hatten wir probleme mit Git/Github, da Livio nicht pushen konnte. Aber auch dies haben wir denke ich
gut umgehen können, da Livio mir dann immer wieder seine Änderungen zugeschickt hat.
 
Für das nächste mal sollten wir uns mehr Zeit nehmen für die Planung, damit wir keinen Stress zu Ende bekommen.
Aber als Abschluss kann ich sagen, dass ich zufrieden mit unserem Produkt bin.

## Sicherheitsaspekte
Für die Login Seite wäre es sicherer wenn das Passwort überhaupt nicht im Source Code steht,
auch wenn hier nur der BCrypt Hash zu sehen ist, ist dies immernoch unsicher wenn man dies in Produktion benutzt.
Also könnte man hier die Sicherheit noch verbessern, jedoch haben wir nicht heraausgefunden wie genau man dies umsetzt.
 
Für die Verschlüsselung haben wir eine Symmterische Verschlüsselung verwendet (AES).
Zusätzlich verwendet unsere Verschlüsselung Salt.
Wir denken die Umsetzung davon ist Sicherheitsmässig nicht perfekt, jedoch trotzdem in Ordnung, da die Passwörter nie unverschlüsselt abgespeichert werden. 

## Weiterführende Gedanken
Hier eine Liste von Dingen, die wir noch umsetzen wollten:
* Einträge editieren
* Login sicherer machen
* Möglichkeit, selber einen User zu erstellen und dafür das Passwort ändern
* Bessere Input Validierung (E-Mail, Login, etc.)
* Schöneres Frontend