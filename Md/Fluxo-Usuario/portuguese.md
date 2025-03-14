# Mapeamento de Usuário
#### [Swagger](http://localhost:8080/swagger-ui/index.html) <br> [Documentação Postman](https://documenter.getpostman.com/view/38340143/2sAY4vi3vF)👨🏾‍🔧

### <div align="center">Controlador de Usuário</div><br>

#### Recebe uma requisição `GET` para `BUSCAR` todos os usuários cadastrados.
##### `Tratamento de Erros:` 
---
<img src="./images/findAll.png">

<br>

#### Recebe uma requisição `GET` para `BUSCAR` o usuario cadastrado a partir do id provido.
##### `Tratamento de Erros:` 
---
<img src="./images/findById.png">

<br>

#### Recebe uma requisição `POST` para `CADASTRAR` um usuário e retorna o usuário registrado.
##### `Tratamento de Erros:` Caso o usuario tentar se `CADASTRAR` e já existir um usuário com as mesmas informações, o sistema retornará uma mensagem informando que o usuário já existe no banco de dados.
---
<img src="./images/createUser.png">

<br>

#### Recebe uma requisição `DELETE` para excluir o usuário com base no login informado e retorna a confirmação de exclusão bem-sucedida.
##### `Tratamento de Erros:` Ou quando ocorrer um erro, o sistema retorna a impossibilidade de exclusão com a justificativa do erro.
---
<img src="./images/deleteUser.png">
</div>

### <div align="center">Documentação do Postman em manutenção</div>

<div align="center">

👨🏾‍🔧[Postman Documentação](https://documenter.getpostman.com/view/38340143/2sAY4vi3vF) 👨🏾‍🔧 

#### Todos os testes e operações da API podem ser acessados através do link da documentação do Postman.<br>Ao clicar para iniciar o programa, acesse o mapeamento usando o site acima.
</div>

###### <br><br><div align="right">A documentação sobre o tratamento de exceções será atualizada em breve</div>
