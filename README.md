# Banco Imobiliário
Banco imobiliário é uma versão de um dos jogos de tabuleiro mais conhecidos e populares do mundo, o *Monopoly*. Neste projeto foi implementada uma versão em Java, que funciona com uma interface textual simples e opera com base nas regras brasileiras do jogo.

## O projeto
O projeto Banco Imobiliário foi desenvolvido pelo aluno, do terceiro período de licenciatura em ciências da computação, Clebson Augusto Fonseca e pelas alunas, também do terceiro período, de bacharelado em sistemas de informação, Amanda Azevedo Martins, Joana Darck Soares da Silva e Joyce Sousa dos Santos.
> Equipe: Equipe 2.</br>
> Link Github: [dcx-cursos/projeto-poo-2019-1-jo/tree/dev](https://github.com/dcx-cursos/projeto-poo-2019-1-jo/tree/dev).</br>
> Link para o relátorio da entrega 3 no Google Docs [aqui!](https://docs.google.com/document/d/1L0anaP1qEhIjeSjO97k65kLi4fCZBfWWgY82ikcp_xA/edit?usp=sharing).

## Instalação
Primeiramente, certifique-se de que você tenha instalados:
 - JDK 8
 - Eclipse ou Netbeans
 - git
 
 em seguida crie um diretório para ser sua Workspace e clone o repositório dentro desta pasta:

    # clonar o repositório:
    git clone https://github.com/dcx-cursos/projeto-poo-2019-1-jo.git

Após ter realizado o paço acima, mude a branch para "entrega3"

    # mudar a branch
    git checkout entrega3
Agora abra o projeto na sua IDE selecionando a opção: 

    # Para o Eclipse
    > File > Open Projects from File System...
    
    # Para o NetBeans
    > Arquivo > Abrir Projeto

Pronto, tudo instalado! 

Para jogar Banco Imobiliário execute a classe `Main.java`,  do pacote `src/ufpb/jogo`.

Para verificar os testes feitos execute a classe `AllTests.java` do pacote `src/ufpb/tests`.

- Para verificar os testes é importante que as seguintes dependências estejam devidamente configuradas: 
	 -  JUnit4
	 - Mockito

## Organização deste repositório
 - `Arquivos/` - Contém arquivos com dados das posições do tabuleiro e conteúdo das cartas de sorte ou revés. 
 - `diagrama-de-classes/` - Contém a versão mais atualizada do diagrama de *UML* do jogo.
 - `lib/`- Contém a dependência do Mockito.
 - `relatorio/`- Contém os arquivos .docx e .pdf do relatório de todas as entregas.
 - `src/` - Contém o pacote  `ufpb/`, nele são encontrados todos os outros pacotes que possuem as classes do sistema do jogo.</br>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- `ufpb/cartas/` - Contém as classes que possuem relação com sorte ou revés. </br>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- `ufpb/exception/` - Contém as classes de exceção.</br>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- `ufpb/jogo/` - Contém as classes que possuem relação com o jogo.</br>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- `ufpb/lougradouros/` - Contém as classes que são posição do tabuleiro.</br>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- `ufpb/opcoes/` - Contém as classes que são comandos do jogo, como por exemplo, jogar, pagar, sair, etc.</br>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- `ufpb/recuperaDados/` - Contém as classes de persistência de dados.</br>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- `ufpb/tests/` - Contém as classes de teste.</br>

## Padrões de projetos implementados
|Padrão de protejo| Maneira como foi implementado |
|--|--|
| Facade  | Foi utilizado como uma fachada de comunicação da logica do banco imobiliário com a parte visível para o jogador. |
| Factory | Foi utilizado para tratar as opções dos jogadores, quando se está na prisão, uma serie de opções está disponível e quando não está as opções normais são usadas.  |
| Strategy| Foi utilizado para em tempo de execução fosse feito um evento/ação do baralho/tabuleiro. Também foi usado na implementação de títulos que tinham um evento muito parecido.s|
| Singleton| Foi utilizado para ter uma classe JogoFacade com uma única instância. |


## Diagrama de classes 

![enter image description here](https://raw.githubusercontent.com/dcx-cursos/projeto-poo-2019-1-jo/entrega3/diagrama-de-classes/diagrama%20da%203%C2%AA%20entrega.png)


- Descrição do diagrama de classes UML

|Nome do Pacote| Descrição |
|--|--|
|ufpb.jogo  | Tabuleiro.java se relaciona com SorteOuReves.java, com recuperaDadosDoTXT.java, com Posicao.java, porque o tabuleiro é composto por posições - que estão dentro do arquivo TXT -, o Jogador.java se relaciona com TituloStrategy.java o jogador é composto por uma lista encadeada de títulos, o JogoFactory.java com Opcao.java,JogoFactoryPrisao.java é um método fábrica que cria as opções do menu do jogo, cada opção tem uma implementação diferente, por fim, o JogoFacade.java é uma fachada para o acesso de métodos de outras classes.|
| ufpb.opcoes | Este pacote é referente às opções que cada jogador tem durante sua jogada. Sendo elas, a opção de jogar - jogar os dados e se movimentar no tabuleiro, de ver o status do jogador(se ele tem títulos, mostrar quais são; o saldo do jogador e a posição no qual está situado), de tentar usar a carta de Habeas Corpus para sair da prisão, de pagar para sair da prisão, de jogar os dados para tentar sair da prisão e a opção de sair do jogo. No padrão JogoFactory, são as opções presentes na “fábrica”, o JogoFactory cria tipos de opções. |
|ufpb.cartas  |Neste pacote são armazenadas as classes que extends a superclasse, SorteOuReves.java. Nela foi criada uma classe para cada tipo de carta de Sorte ou Revés, que realizam ações com base na sua descrição. Na classe de SorteOuReves.java, onseguimos agrupar as cartas como sendo do tipo Pague, em que o jogador tem que pagar algum valor ao banco, Presente, em que todos os jogadores pagam alguma quantia ao jogador que retirou esse carta da pilha, Receba, em que o jogador recebe uma quantia do banco, Vá para prisão, em que o jogador é mandado para a prisão, Habeas Corpus, em que o jogador ao possuir esta carta pode-se livrar da prisão e Sorte ou Revés, que a depender do resultado da soma dos dados, ou ele paga ou recebe alguma quantia do banco. Neste pacote são armazenadas as classes que extends a superclasse, Sorte ou revés. Nela foi criada uma classe para cada tipo descrito acima, que realizam ações com base na sua descrição. |
| ufpb.lougradouros | Por implementar Posicao.java, todas as classes deste pacote possuem um método evento(), esse método possibilita que ao o jogador se mover no tabuleiro e parar em uma nova posição, ele executa apenas a ação prevista para aquela posição. |
| ufpb.exception | Todas as exceções deste pacote são lançadas e tratadas nas classes Conta.java, Jogador.java, JogoFacade.java, JogoFactory.java, JogoFactoryPrisao.java e Jogo.java, do pacote ufpb.jogo , tais como, se a cor que um jogador escolheu para si é uma cor possível, se um valor de dinheiro é válido , se algum limite foi excedido, entre outros. Este pacote possibilita que existam exceções mais especializadas, para que possamos tratá las para entender melhor alguns erros.|
| ufpb.recuperaDados | Este pacote é referente a camada de persistência de dados em arquivos, onde conseguimos recuperar os dados, em forma de String dos arquivos .txt, para serem convertidos em objetos na classe Tabuleiro.java.|

