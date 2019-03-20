Feature: yo como usuario quiero una contraseña con restriccion de caracteres para que el ingreso sea mas seguro.


Scenario: clave con solo numeros
Given ana uso el usuario abcd1234
When intenta autenticarse con la clave 1111
Then observa el mensaje La contraseña no cumple el formato requerido, por favor intente nuevamente.


Scenario: clave con solo letras
Given ana uso el usuario abcd1234
When intenta autenticarse con la clave aaaa
Then observa el mensaje La contraseña no cumple el formato requerido, por favor intente nuevamente.

Scenario: clave con solo caracteres especiales
Given ana uso el usuario abcd1234
When intenta autenticarse con la clave ****
Then observa el mensaje La contraseña no cumple el formato requerido, por favor intente nuevamente.

Scenario: clave vacia
Given ana uso el usuario abcd1234
When intenta autenticarse con la clave ""
Then no puede continuar
