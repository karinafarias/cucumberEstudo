Feature: Passagem

@t
Scenario: CT0001 busca de passagem ida e volta - voo direto
	Given que o usuário acessa o browser                       
	When acesso o site        
	And preencho o campo origem                                 
	And preencho o campo destino
	And seleciono a data de ida
	And seleciono a data de volta
	And seleciono a quantidade de passageiro adulto
	And seleciono a quantidade de passageiro crianca
	And seleciono a classe da passagem
	And cliclo em aplicar
	And clico em procurar
	Then o site exibe os voos na tela
	
Scenario: CT0002 selecionar voo
	Given que o usuario faça uma busca
	And filtro por voo direto                                          
	And seleciono a passagem com menor preço          
	Then o site encaminha usuario para tela de pagamento
	

Scenario: CT0003 fazer pagamento	
    Given que o usuario faça uma busca
	And selecione um voo
	And seleciono a forma de pagamento
	And preencho informações dos passageiros
	And preencho informações sobre voucher
	And preencho o telefone de contato
	Then verifico se as informações estão corretas
	And clico no termo
	
	

	
	
	





