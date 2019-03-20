Feature: Yo como usuario quiero que el campo usuario cumpla con restricciones de caracteres para que sea mas seguro

Scenario: usuario con solo letras
Given Zalustrio abre la SVP
When intenta autenticarse con el usuario aaaa
Then observa el mensaje El usuario no cumple el formato requerido, por favor intente nuevamente.

Scenario: usuario con solo numeros
Given Zalustrio abre la SVP
When intenta autenticarse con el usuario 1234
Then observa el mensaje El usuario no cumple el formato requerido, por favor intente nuevamente.

Scenario: usuario vacio
Given Zalustrio abre la SVP
When intenta autenticarse con el usuario "" 
Then no puede continuar

Scenario: usuario con caracteres especiales
Given Zalustrio abre la SVP
When intenta autenticarse con el usuario ****  
Then observa el mensaje El usuario no cumple el formato requerido, por favor intente nuevamente.

Scenario: usuario correcto
Given Zalustrio abre la SVP
When intenta autenticarse con el usuario acbd1234 
Then observa el ingreso de la clave




