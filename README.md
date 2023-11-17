
Git
1. Criar repositório privado
2. Dar acesso
3. Clonar repositório na máquina
4. Criar uma branch sua
5. Sempre comitar correções com sufixo fix, chore, ou feat
6. Sempre mergear para branch main da sua branch
7. Sempre subir a versão da aplicação no pom

Spring
1. Criar projeto pelo spring initializer
2. Colocar projeto no repositório
3. Colocar esse conteúdo no read.me
4. Comitar e fazer o push
5. Mergear com a main 

Código
1. Construir uma api com dois endpoints
2. GET http://localhost:8080/citacao/aleatoria > retorna uma citação aleatório. Esse endpoint consome o endpoint http://localhost:8081/api/random
3. GET http://localhost:8080/citacao > retorna todas citações. Esse endpoint consome o endpoint http://localhost:8081/api
4. Seguir os tratamentos abaixo

Sempre que retornar value.id com valor par, então remover todos os espaços do quote
Sempre que retornar value.id com valor impar, então concatenar com a palavra impar
Sempre que retornar value maior que 10, então concatenar com a palavra grande

Retornar do seguinte formato
{
    "citacao": {
        "valor": "valor da citação"
    }
}
OU no caso da lista
[
{
    "citacao": {
        "valor": "valor da citação"
    }
}
]

Fazer os testes unitários avaliando as condições

