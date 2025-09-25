# 🎬 The Movie

Aplicativo Android desenvolvido em **Kotlin** que consome a API do [The
Movie Database (TMDb)](https://api.themoviedb.org/) para exibir filmes
em alta do dia.\
O projeto foi construído seguindo os princípios de **Clean
Architecture + MVVM**, utilizando **Jetpack Compose** para a interface.

------------------------------------------------------------------------

## 🎬 O App
![Screen_recording_20250925_000623 webm](https://github.com/user-attachments/assets/d2b135cf-11e8-48f6-b8e6-6dcdef0e56dd)


------------------------------------------------------------------------
## 🚀 Funcionalidades principais

-   **Listagem de filmes em alta do dia**
    -   Exibe título, imagem de fundo (backdrop) e nota de avaliação
        (vote_average).\
-   **Integração com TMDb API** via Retrofit + OkHttp.\
-   **Imagens carregadas com Coil**.\
-   **Gerenciamento de estado com Flow e coroutines**.\
-   **Injeção de dependências com Hilt**.\
-   **Tratamento de Resultados** padronizado (Success / Error /
    Loading).\
-   **Logs de rede** apenas em builds de Debug.\
-   **Arquitetura em camadas**:
    -   `data`: Repositórios, DTOs e integração com API\
    -   `domain`: Modelos de domínio + UseCases\
    -   `ui`: Telas em Jetpack Compose (Movie List)\
    -   `core`: Result, interceptors, dispatchers e utilitários

------------------------------------------------------------------------

## 🛠️ Tecnologias utilizadas

-   **Kotlin** com **Coroutines + Flow**
-   **Jetpack Compose + Material 3 + Navigation Compose**
-   **Hilt** para injeção de dependência
-   **Retrofit + OkHttp** com interceptor de logging
-   **kotlinx.serialization** para serialização JSON
-   **Coil** para carregamento de imagens
-   **JUnit5, MockK, Turbine, coroutines-test** para testes unitários
-   **Gradle Version Catalogs** (`libs.versions.toml`)

------------------------------------------------------------------------

## 📱 Navegação

-   **movie_list** → tela principal que lista os filmes em alta.

------------------------------------------------------------------------

## 🔑 Configuração da API

Crie um arquivo `local.properties` na raiz do projeto e adicione:

    API_KEY=Bearer SEU_TOKEN_AQUI

> ⚠️ O prefixo `Bearer` é necessário, pois o TMDb exige autenticação via
> header `Authorization`.

A chave será exposta em tempo de build via `BuildConfig.API_KEY`.

------------------------------------------------------------------------

## ▶️ Como rodar o app

1.  Clone este repositório

2.  Configure sua chave de API no `local.properties`

3.  Execute o build:

    ``` bash
    ./gradlew assembleDebug
    ```

4.  Rode no emulador ou dispositivo físico via Android Studio.

------------------------------------------------------------------------

## 🧪 Testes

-   **Rodar testes unitários**

    ``` bash
    ./gradlew test
    ```

-   **Rodar lint (ktlint ou detekt)**

    ``` bash
    ./gradlew ktlintCheck
    ```

------------------------------------------------------------------------

## 📂 Próximos passos

-   Implementar paginação com Paging 3
-   Adicionar tela de detalhes de filme
-   Implementar cache offline (Room ou DataStore)
-   Melhorar cobertura de testes
-   Suporte a internacionalização (multi-idioma)
