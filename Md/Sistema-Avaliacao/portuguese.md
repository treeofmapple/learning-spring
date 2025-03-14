# Avaliation System
#### [Swagger](http://localhost:8080/swagger-ui/index.html) <br> [Documentação Postman](https://)👨🏾‍🔧

### <div align="center">Controlador de Usuário</div><br>

#### Recebe uma requisição `GET` para `BUSCAR` todos os usuários cadastrados.
##### `Tratamento de Erros:`
---
<img src="./images/UsuarioController/findAllUsuarios.png">

<br>

#### Recebe uma requisição `GET` para `BUSCAR` o usuário cadastrado com base no ID inserido.
##### `Tratamento de Erros:`
---
<img src="./images/UsuarioController/findById.png">

<br>

#### Recebe uma requisição `POST` para `REGISTRAR` o usuário e retorna o ID do usuário cadastrado.
##### `Tratamento de Erros:`
---
<img src="./images/UsuarioController/createUsuario.png">

<br>

#### Recebe uma requisição `PUT` para `ATUALIZAR` o usuário com base nas informações fornecidas e retorna com a atualização bem-sucedida do conteúdo.
##### `Tratamento de Erros:`
---
<img src="./images/UsuarioController/updateUsuario.png">

<br>

#### Recebe uma requisição `DELETE` para deletar o usuário com base nas informações fornecidas e retorna com a exclusão bem-sucedida do conteúdo.
##### `Tratamento de Erros:`
---
<img src="./images/UsuarioController/deleteUsuario.png">

<br>

### <div align="center">Controlador de Avaliação</div>

<br>

#### Recebe uma requisição `GET` para `BUSCAR` todas as avaliações cadastradas.
##### `Tratamento de Erros:`
---
<img src="./images/AvaliacaoController/findAllAvaliacao.png">

<br>

#### Recebe uma requisição `GET` para `BUSCAR` a avaliação cadastrada com base no ID fornecido.
##### `Tratamento de Erros:`
---
<img src="./images/AvaliacaoController/findById.png">

<br>

#### Recebe uma requisição `POST` para `REGISTRAR` a avaliação e retorna a avaliação cadastrada.
##### `Tratamento de Erros:`
---
<img src="./images/AvaliacaoController/createAvaliacao.png">

<br>

#### Recebe uma requisição `PUT` para `ATUALIZAR` a avaliação com base nas informações fornecidas e retorna com a atualização bem-sucedida do conteúdo.
##### `Tratamento de Erros:`
---
<img src="./images/AvaliacaoController/updateAvaliacao.png">

<br>

#### Recebe uma requisição `DELETE` para deletar a avaliação com base nas informações fornecidas e retorna com a exclusão bem-sucedida do conteúdo.
##### `Tratamento de Erros:`
---
<img src="./images/AvaliacaoController/deleteAvaliacao.png">

<br>

### <div align="center">Notas Usuarios Controller</div>

<br>

#### Recebe uma requisição `GET` para `BUSCAR` usuários com mais de duas avaliações, somando as notas do usuário e dividindo pela quantidade de avaliações de cada usuário. <br> Retorna todos os usuários com suas médias e suas notas fornecidas.
##### `Tratamento de Erros:`
---
<img src="./images/NotasUsuariosController/getAllMediaUsuario.png">

<br>

#### Recebe uma requisição `GET` para `BUSCAR` usuários com mais de duas avaliações, somando as notas do usuário e dividindo pela quantidade de avaliações de cada usuário. <br> Retorna a média fornecida para o usuário com o ID solicitado.
##### `Tratamento de Erros:`
---
<img src="./images/NotasUsuariosController/mediaDeUmUsuario.png">

### <div align="center">Documentação do Postman em manutenção</div>

<div align="center">

👨🏾‍🔧[Postman Documentação](https://documenter.getpostman.com/view/38340143/2sAY4vi3vF) 👨🏾‍🔧 

#### Todos os testes e operações da API podem ser acessados através do link da documentação do Postman. <br> Ao clicar para iniciar o programa, acesse o mapeamento usando o site acima.
</div>

###### <br><br><div align="right">A documentação sobre o tratamento de exceções será atualizada em breve</div>
