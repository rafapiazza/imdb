# imdb
interview

# Disclaimer
Conforme conversamos na entrevista, existe um time de devOps, security, Dba, observability que da suporte ao meus projetos nesses últimos anos.
Então no final de semana que tirei pra desenvolver essa solução, precisei ler e reler documentações, aulas e experimentar coisas como o flyway,
o banco em si, openApi, autenticação, authorização, entre outros.
Caso algum padrão não seja o mais atual ou eficiente, podemos discutir sobre o/

# Primeiros passos:
Buildar o gradle
Rodar o programa
Esperar as tabelas serem criadas e populadas

A aplicação pode ser acessada via endpoint com a autenticação, mas recomendo usar o próprio swagger
Acessar http://localhost:8080/swagger-ui/index.html#/

Realizar cadastro através do endpoint de registro

Realizar login e copiar o token de resposta

Pressionar o botão "Authorize" e colar o token

Pronto, já está autorizado até a página ser recarregada

# requisitos

# user-controller /user (singular)
Cadastro de usuários no endpoint register

Edição de usuários no endpoint update

Exclusão lógica no endpoint username (como não se trata de um delete, a optei por não expor semântica pesada)

Listagem de usuário alfabética com opção de paginação no listUser

# vote-controller /votes
Voto de usuários não admin são realizados no /username , passando score e movieID no corpo

# movie-controller /movies
Cadastro para admin no enpoint username , passando titulo, generos, diretor e atores no corpo

Listagem paginada de filmes por diretor no endpoint director

Listagem paginada de filmes por genero no endpoint genre

Listagem paginada de filmes por ator no endpoint actor

Exibição de todas as informações do filme, como a média dos votos no endpoint title

Listagem ordenadas por filmes mais votados em ordem alfabética no endpoint mostVoted


# Sugestões e melhorias:
Criação de arquivos de configuração para o properties em casos específicos, gerenciamento de roles sem bloquear o swagger para facilitamento de permissões de acessos,
definir estratégias para salvar e usar token em sessões ou em banco para não precisar autenticar, vincular voto ao usuario possibilitando tracking de anomalias, 
verificar necessidade de verificação de "authenticidade" de campos, como o score dos votos, implementar response entity para padrão de respostas.

# obs
Não foi possível realizar a tempo os testes e verificar como implantar o docker, na categoria extras.
