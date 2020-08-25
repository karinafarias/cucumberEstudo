# language : pt

Funcionalidade: Acessar a API em https://jsonplaceholder.typicode.com/posts/1 e realizar validações
Como usuário  

Cenario: Validar o esquema
Dado que eu faço uma requisição
Então eu valido o esquema fornecido

Cenario: Validar o código de resposta
Dado que eu faço uma requisição
Então eu obtenho um código de sucesso

Cenario: Validar o formato do JSON de resposta 
Dado que eu faço uma requisição
Então eu obtenho uma resposta em formato válido

Cenario: Validar o conteúdo da chave de name
Dado que eu faço uma requisição
Então valido se a chave name retorna o valor correto

Cenario: Validar o conteúdo da chave Content-Type do Header
Dado que eu faço uma requisição
Então valido se a chave Content-type retorna o valor correto