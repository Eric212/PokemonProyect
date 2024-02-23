### Índice
- [Índice](#índice)
- [Clases Normales ](#clases-normales-)
  - [1.1 Alineacion](#11-alineacion)
  - [1.2 Combate](#12-combate)
  - [1.3 Entrenador](#13-entrenador)
  - [1.4 Mercado](#14-mercado)
  - [1.5 Pokemon](#15-pokemon)
  - [1.6 Resultado](#16-resultado)
  - [1.7 Ronda](#17-ronda)
  - [1.8 Token](#18-token)
  - [1.9 Usuario](#19-usuario)
- [Clases DTO ](#clases-dto-)
  - [2.1 AlineacionDTO](#21-alineaciondto)
  - [2.2 CombateDTO](#22-combatedto)
  - [2.3 EntrenadorDTO](#23-entrenadordto)
  - [2.4 MercadoDTO](#24-mercadodto)
  - [2.5 PokemonDTO](#25-pokemondto)
  - [2.6 ResultadoDTO](#26-resultadodto)
  - [2.7 RondaDTO](#27-rondadto)
  - [2.8 TokenDTO](#28-tokendto)
  - [2.9 UsuarioDTO](#29-usuariodto)
- [ 3. Fragments](#-3-fragments)
  - [3.1. WelcomeFragment](#31-welcomefragment)
  - [3.2. AlignmentFragment](#32-alignmentfragment)
  - [3.3. BattleFragment](#33-battlefragment)
  - [3.4. FightFragment](#34-fightfragment)
  - [3.5. PlayerCreatorFragment](#35-playercreatorfragment)
  - [3.6. PokedexFragment](#36-pokedexfragment)
  - [3.7. PokemonDetailFragment](#37-pokemondetailfragment)
  - [3.8. StartMenu](#38-startmenu)
  - [3.9. TrainerFragment](#39-trainerfragment)
- [Adaptadores ](#adaptadores-)
  - [AlignmentAdapter](#alignmentadapter)
    - [Propósito:](#propósito)
    - [Atributos Principales:](#atributos-principales)
    - [Métodos Principales:](#métodos-principales)
  - [PokemonAlignmentDetailViewHolder](#pokemonalignmentdetailviewholder)
    - [Propósito:](#propósito-1)
    - [Atributos Principales:](#atributos-principales-1)
    - [Métodos Principales:](#métodos-principales-1)
  - [AlineacionAdapter](#alineacionadapter)
    - [Propósito:](#propósito-2)
    - [Atributos Principales:](#atributos-principales-2)
    - [Métodos Principales:](#métodos-principales-2)
  - [AlieacionViewHolder](#alieacionviewholder)
    - [Propósito:](#propósito-3)
    - [Atributos Principales:](#atributos-principales-3)
    - [Métodos Principales:](#métodos-principales-3)
  - [OponentAdapter](#oponentadapter)
    - [Propósito:](#propósito-4)
    - [Atributos Principales:](#atributos-principales-4)
    - [Métodos Principales:](#métodos-principales-4)
  - [OponentViewHolder](#oponentviewholder)
    - [Propósito:](#propósito-5)
    - [Atributos Principales:](#atributos-principales-5)
    - [Métodos Principales:](#métodos-principales-5)
  - [PokemonAdapter](#pokemonadapter)
    - [Propósito:](#propósito-6)
    - [Atributos Principales:](#atributos-principales-6)
    - [Métodos Principales:](#métodos-principales-6)
  - [PokemonViewHolder](#pokemonviewholder)
    - [Propósito:](#propósito-7)
    - [Atributos Principales:](#atributos-principales-7)
    - [Métodos Principales:](#métodos-principales-7)
  - [PokemonAdapter](#pokemonadapter-1)
  - [Propósito](#propósito-8)
    - [Atributos Principales](#atributos-principales-8)
    - [Métodos Principales](#métodos-principales-8)
  - [PokemonViewHolder](#pokemonviewholder-1)
    - [Propósito](#propósito-9)
    - [Atributos Principales](#atributos-principales-9)
    - [Métodos Principales](#métodos-principales-9)
  - [TrainerPokemonAdapter](#trainerpokemonadapter)
    - [Propósito](#propósito-10)
    - [Atributos Principales](#atributos-principales-10)
    - [Métodos Principales](#métodos-principales-10)
  - [TrainerPokemonViewHolder](#trainerpokemonviewholder)
    - [Propósito](#propósito-11)
    - [Atributos Principales](#atributos-principales-11)
    - [Métodos Principales](#métodos-principales-11)
  - [WelcomeAdapter](#welcomeadapter)
    - [Propósito](#propósito-12)
    - [Atributos Principales](#atributos-principales-12)
    - [Métodos Principales](#métodos-principales-12)
  - [WelcomeViewHolder](#welcomeviewholder)
    - [Propósito](#propósito-13)
    - [Atributos Principales](#atributos-principales-13)
    - [Métodos Principales](#métodos-principales-13)



---

### Clases Normales <a name="clases-normales"></a>

#### <a name="alineacion"></a>1.1 Alineacion
- Propósito: Representa una alineación en el proyecto Pokémon.
- Atributos:
  - `id`: Identificador único de la alineación.
  - `zona`: Zona de la alineación.

#### <a name="combate"></a>1.2 Combate
- Propósito: Representa un combate en el proyecto Pokémon.
- Atributos:
  - `id`: Identificador único del combate.
  - `fecha`: Fecha del combate.
  - `usuarioWinner`: Identificador del usuario ganador.
  - `jugadorWinner`: Identificador del jugador ganador.
  - `usuarioId`: Identificador del usuario.
  - `entrenadorId`: Identificador del entrenador.

#### <a name="entrenador"></a>1.3 Entrenador
- Propósito: Representa un entrenador en el proyecto Pokémon.
- Atributos:
  - `id`: Identificador único del entrenador.
  - `nombre`: Nombre del entrenador.
  - `apellido`: Apellido del entrenador.
  - `genero`: Género del entrenador.
  - `icono`: Icono del entrenador.
  - `dinero`: Dinero del entrenador.
  - `pokemons`: Lista de Pokémon del entrenador.
  - `resultados`: Lista de resultados del entrenador.

#### <a name="mercado"></a>1.4 Mercado
- Propósito: Representa un mercado en el proyecto Pokémon.
- Atributos:
  - `id`: Identificador único del mercado.
  - `fecha`: Fecha del mercado.
  - `pokemons`: Lista de Pokémon disponibles en el mercado.

#### <a name="pokemon"></a>1.5 Pokemon
- Propósito: Representa un Pokémon en el proyecto Pokémon.
- Atributos:
  - `id`: Identificador único del Pokémon.
  - `name`: Nombre del Pokémon.
  - `type`: Tipo del Pokémon.
  - `level`: Nivel del Pokémon.
  - `hp`: Puntos de salud del Pokémon.
  - `attack`: Poder de ataque del Pokémon.
  - `defence`: Poder de defensa del Pokémon.
  - `speed`: Velocidad del Pokémon.
  - `gender`: Género del Pokémon.
  - `valor`: Valor del Pokémon.
  - `hiresURL`: URL de la imagen del Pokémon.
  - `entrenador`: Identificador del entrenador asociado.
  - `mercadoId`: Identificador del mercado asociado.
  - `alineacionId`: Identificador de la alineación asociada.

#### <a name="resultado"></a>1.6 Resultado
- Propósito: Representa un resultado en el proyecto Pokémon.
- Atributos:
  - `id`: Identificador único del resultado.

#### <a name="ronda"></a>1.7 Ronda
- Propósito: Representa una ronda en el proyecto Pokémon.
- Atributos:
  - `id`: Identificador único de la ronda.
  - `dadoJugador`: Valor del dado del jugador.
  - `dadoUsuario`: Valor del dado del usuario.
  - `usuWinner`: Identificador del usuario ganador.
  - `playerWinner`: Identificador del jugador ganador.
  - `combate`: Identificador del combate asociado.

#### <a name="token"></a>1.8 Token
- Propósito: Representa un token en el proyecto Pokémon.
- Atributos:
  - `token`: El token en sí.

#### <a name="usuario"></a>1.9 Usuario
- Propósito: Representa un usuario en el proyecto Pokémon.
- Atributos:
  - `id`: Identificador único del usuario.
  - `username`: Nombre de usuario.
  - `password`: Contraseña del usuario.
  - `token`: Token del usuario.

---

### Clases DTO <a name="clases-dto"></a>

#### <a name="alineaciondto"></a>2.1 AlineacionDTO
- Propósito: Representa una alineación en el proyecto Pokémon.
- Atributos:
  - `id`: Identificador único de la alineación.
  - `zona`: Zona de la alineación.

#### <a name="combatedto"></a>2.2 CombateDTO
- Propósito: Representa un combate en el proyecto Pokémon.
- Atributos:
  - `id`: Identificador único del combate.
  - `fecha`: Fecha del combate.
  - `usuarioWinner`: Identificador del usuario ganador.
  - `jugadorWinner`: Identificador del jugador ganador.
  - `usuarioId`: Identificador del usuario.
  - `entrenadorId`: Identificador del entrenador.

#### <a name="entrenadordto"></a>2.3 EntrenadorDTO
- Propósito: Representa un entrenador en el proyecto Pokémon.
- Atributos:
  - `id`: Identificador único del entrenador.
  - `nombre`: Nombre del entrenador.
  - `apellido`: Apellido del entrenador.
  - `genero`: Género del entrenador.
  - `icono`: Icono del entrenador.
  - `dinero`: Dinero del entrenador.
  - `pokemons`: Lista de Pokémon del entrenador.
  - `resultados`: Lista de resultados del entrenador.

#### <a name="mercadodto"></a>2.4 MercadoDTO
- Propósito: Representa un mercado en el proyecto Pokémon.
- Atributos:
  - `id`: Identificador único del mercado.
  - `fecha`: Fecha del mercado.
  - `pokemons`: Lista de Pokémon disponibles en el mercado.

#### <a name="pokemondto"></a>2.5 PokemonDTO
- Propósito: Representa un Pokémon en el proyecto Pokémon.
- Atributos:
  - `id`: Identificador único del Pokémon.
  - `name`: Nombre del Pokémon.
  - `type`: Tipo del Pokémon.
  - `level`: Nivel del Pokémon.
  - `hp`: Puntos de salud del Pokémon.
  - `attack`: Poder de ataque del Pokémon.
  - `defence`: Poder de defensa del Pokémon.
  - `speed`: Velocidad del Pokémon.
  - `gender`: Género del Pokémon.
  - `valor`: Valor del Pokémon.
  - `hiresURL`: URL de la imagen del Pokémon.
  - `entrenador`: Identificador del entrenador asociado.
  - `mercadoId`: Identificador del mercado asociado.
  - `alineacionId`: Identificador de la alineación asociada.

#### <a name="resultadodto"></a>2.6 ResultadoDTO
- Propósito: Representa un resultado en el proyecto Pokémon.
- Atributos:
  - `id`: Identificador único del resultado.

#### <a name="rondadto"></a>2.7 RondaDTO
- Propósito: Representa una ronda en el proyecto Pokémon.
- Atributos:
  - `id`: Identificador único de la ronda.
  - `dadoJugador`: Valor del dado del jugador.
  - `dadoUsuario`: Valor del dado del usuario.
  - `usuWinner`: Identificador del usuario ganador.
  - `playerWinner`: Identificador del jugador ganador.
  - `combate`: Identificador del combate asociado.

#### <a name="tokendto"></a>2.8 TokenDTO
- Propósito: Representa un token en el proyecto Pokémon.
- Atributos:
  - `token`: El token en sí.

#### <a name="usuariodto"></a>2.9 UsuarioDTO
- Propósito: Representa un usuario en el proyecto Pokémon.
- Atributos:
  - `id`: Identificador único del usuario.
  - `username`: Nombre de usuario.
  - `password`: Contraseña del usuario.
  - `token`: Token del usuario.

### <a name="fragments"> 3. Fragments

#### <a name="welcomefragment"></a>3.1. WelcomeFragment
- **Propósito:** Representa la pantalla de bienvenida del juego Pokémon.
- **Atributos Principales:**
  - `ivZona1Posicion1` a `ivPokemonZona4Posicion2`: Imágenes que representan las diferentes posiciones de los Pokémon en la interfaz.
  - `rvPokemonsAlineados1` a `rvPokemonsAlineados4`: RecyclerViews que muestran los Pokémon alineados en diferentes zonas.
- **Métodos Principales:**
  - `onViewCreated(View view, Bundle savedInstanceState)`: Inicializa y configura los elementos de la interfaz de usuario.
  - `onAttach(Context context)`: Se llama cuando el fragmento se adjunta a la actividad principal.
  - `onClick(View v)`: Maneja los clics en los elementos de la interfaz de usuario.

#### <a name="alignmentfragment"></a>3.2. AlignmentFragment
- **Propósito:** Representa la pantalla de alineación de Pokémon del juego Pokémon.
- **Atributos Principales:**
  - `ivZona1Posicion1` a `ivPokemonZona4Posicion2`: Imágenes que representan las diferentes posiciones de los Pokémon en la interfaz.
  - `rvPokemonsAliniacion`: RecyclerView que muestra los Pokémon disponibles para alinear.
- **Métodos Principales:**
  - `onViewCreated(View view, Bundle savedInstanceState)`: Inicializa y configura los elementos de la interfaz de usuario.
  - `onAttach(Context context)`: Se llama cuando el fragmento se adjunta a la actividad principal.
  - `onClick(View v)`: Maneja los clics en los elementos de la interfaz de usuario.
  - `onClick(int position)`: Maneja los clics en los Pokémon disponibles para alinear.

#### <a name="battlefragment"></a>3.3. BattleFragment
- **Propósito:** Representa la pantalla de combate del juego Pokémon.
- **Atributos Principales:**
  - `rvOponents`: RecyclerView que muestra una lista de oponentes disponibles para el combate.
  - `ivHome`, `ivTrainer`, `ivPokedex`, `ivBattle`, `ivMarket`: Imágenes que representan las diferentes opciones de navegación en el menú.
  - `menuLayout`: Vista que contiene los elementos del menú de navegación.
- **Métodos Principales:**
  - `onViewCreated(View view, Bundle savedInstanceState)`: Inicializa y configura los elementos de la interfaz de usuario.
  - `onAttach(Context context)`: Se llama cuando el fragmento se adjunta a la actividad principal.
  - `onClick(View v)`: Maneja los clics en los elementos de la interfaz de usuario.

#### <a name="fightfragment"></a>3.4. FightFragment
- **Propósito:** Representa la pantalla de combate del juego Pokémon.
- **Atributos Principales:**
  - `pokeballsJugador`: Lista de ImageView que representan las pokebolas del jugador.
  - `pokeballsBot`: Lista de ImageView que representan las pokebolas del bot.
  - `pokemonJugador`: Pokemon seleccionado por el jugador para el combate.
  - `pokemonContrincante`: Pokemon seleccionado por el contrincante para el combate.
  - `resultadosRondas`: Lista que almacena los resultados de las rondas del combate.
  - `pokemonsEliminadosJugador`: Lista de Pokemon eliminados del jugador durante el combate.
  - `pokemonsEliminadosContrincante`: Lista de Pokemon eliminados del contrincante durante el combate.
  - `idContrincante`: Identificador del contrincante.
- **Métodos Principales:**
  - `onViewCreated(View view, Bundle savedInstanceState)`: Inicializa y configura los elementos de la interfaz de usuario.
  - `onAttach(Context context)`: Se llama cuando el fragmento se adjunta a la actividad principal.

#### <a name="playercreatorfragment"></a>3.5. PlayerCreatorFragment
- **Propósito:** Representa la pantalla de creación de jugador en el juego Pokémon.
- **Atributos Principales:**
  - `ivJugador`: ImageView para mostrar el avatar del jugador.
  - `etNombreJugador`: EditText para introducir el nombre del jugador.
  - `etApellidoJugador`: EditText para introducir el apellido del jugador.
  - `genero`: RadioGroup para seleccionar el género del jugador.
  - `rbMasculino`: RadioButton para seleccionar el género masculino.
  - `rbFemenino`: RadioButton para seleccionar el género femenino.
  - `avatares`: Lista de avatares disponibles para el jugador.
  - `bCrear`: Botón para crear el jugador.
  - `imageId`: Identificador del avatar seleccionado.
  - `listener`: Interfaz para gestionar los eventos de clic.
  - `api`: Instancia de la interfaz de servicio de API.
- **Métodos Principales:**
  - `onViewCreated(View view, Bundle savedInstanceState)`: Inicializa y configura los elementos de la interfaz de usuario.
  - `onAttach(Context context)`: Se llama cuando el fragmento se adjunta a la actividad principal.

#### <a name="pokedexfragment"></a>3.6. PokedexFragment
- **Propósito:** Representa la pantalla de la Pokédex en el juego Pokémon.
- **Atributos Principales:**
  - `api`: Instancia de la interfaz de servicio de API.
  - `pokemons`: Lista de Pokémon obtenidos de la API.
  - `listener`: Interfaz para gestionar los eventos de clic.
  - `menuLayout`: Vista del menú de la aplicación.
  - `ivTrainer`, `ivPokedex`, `ivBattle`, `ivMarket`, `ivHome`: ImageViews para las diferentes opciones del menú.
- **Métodos Principales:**
  - `onViewCreated(View view, Bundle savedInstanceState)`: Inicializa y configura los elementos de la interfaz de usuario.
  - `onAttach(Context context)`: Se llama cuando el fragmento se adjunta a la actividad principal.
  - `onClick(View v)`: Método para gestionar los clics en las opciones del menú.

#### <a name="pokemondetailfragment"></a>3.7. PokemonDetailFragment
- **Propósito:** Representa la pantalla de detalle de un Pokémon en el juego Pokémon.
- **Atributos Principales:**
  - `api`: Instancia de la interfaz de servicio de API.
  - `pokemonId`: Identificador del Pokémon cuyos detalles se van a mostrar.
  - `listener`: Interfaz para gestionar los eventos de clic.
  - `menuLayout`: Vista del menú de la aplicación.
  - `ivHome`, `ivTrainer`, `ivPokedex`, `ivBattle`, `ivMarket`: ImageViews para las diferentes opciones del menú.
- **Métodos Principales:**
  - `onViewCreated(View view, Bundle savedInstanceState)`: Inicializa y configura los elementos de la interfaz de usuario.
  - `onAttach(Context context)`: Se llama cuando el fragmento se adjunta a la actividad principal.
  - `onClick(View v)`: Método para gestionar los clics en las opciones del menú.

#### <a name="startmenu"></a>3.8. StartMenu
- **Propósito:** Representa el fragmento de inicio de sesión y registro en la aplicación.
- **Atributos Principales:**
  - `preference`: Almacena las preferencias de inicio de sesión del usuario.
  - `listener`: Interfaz para gestionar los eventos de clic.
  - `etUsername`, `etPassword`: EditTexts para el nombre de usuario y la contraseña.
  - `tvAlert`: TextView para mostrar mensajes de alerta.
  - `bLogIn`, `bSignIn`: Buttons para iniciar sesión y registrar un nuevo usuario, respectivamente.
  - `ivPreference`: ImageView para gestionar las preferencias de inicio de sesión.
  - `api`: Instancia de la interfaz de servicio de API.
  - `token`: Token de autenticación del usuario.
  - `cbRemember`: CheckBox para recordar el inicio de sesión del usuario.
  - `context`: Contexto de la actividad que aloja el fragmento.
- **Métodos Principales:**
  - `onViewCreated(View view, Bundle savedInstanceState)`: Inicializa y configura los elementos de la interfaz de usuario.
  - `onAttach(Context context)`: Se llama cuando el fragmento se adjunta a la actividad principal.
  - `onClick(View v)`: Método para gestionar los clics en los botones de inicio de sesión, registro y preferencias.

#### <a name="trainerfragment"></a>3.9. TrainerFragment
- **Propósito:** Representa el fragmento que muestra el perfil del entrenador y los pokémon que posee.
- **Atributos Principales:**
  - `ivEntrenador`: ImageView para mostrar la imagen del entrenador.
  - `tvDinero`: TextView para mostrar el dinero del entrenador.
  - `ivPokemon`: ImageView para mostrar la imagen del Pokémon seleccionado.
  - `ivBackgroundDetail`: ImageView para el fondo de la información detallada del Pokémon.
  - `pbLife`: ProgressBar para mostrar la vida del Pokémon.
  - `tvNombreInfo`, `tvNivelInfo`, `tvAtaqueInfo`, `tvDefensaInfo`, `tvVelocidadInfo`: TextViews para mostrar información detallada del Pokémon.
  - `tvNombre`, `tvNivel`, `tvAtaque`, `tvDefensa`, `tvVelocidad`: TextViews para mostrar los valores de nombre, nivel, ataque, defensa y velocidad del Pokémon.
  - `bCrearAlineacion`: Button para crear una alineación de Pokémon.
  - `menuLayout`: Layout para mostrar el menú de navegación.
  - `ivHome`, `ivTrainer`, `ivPokedex`, `ivBattle`, `ivMarket`: ImageViews para las opciones de navegación.
- **Métodos Principales:**
  - `onViewCreated(View view, Bundle savedInstanceState)`: Inicializa y configura los elementos de la interfaz de usuario.
  - `onAttach(Context context)`: Se llama cuando el fragmento se adjunta a la actividad principal.
  - `onLongClick(PokemonDTO pokemon)`: Método para mostrar la información detallada de un Pokémon al hacer clic largo.
  - `onClick(View v)`: Método para gestionar los clics en los botones y las opciones de navegación.

### Adaptadores <a name="clases-normales"></a>

#### AlignmentAdapter

##### Propósito:
Clase que implementa un adaptador para la alineación de Pokémon en el juego Pokémon.

##### Atributos Principales:
- `pokemons`: Lista de Pokémon para alinear.
- `listener`: Interfaz para gestionar los eventos de clic.

##### Métodos Principales:
- `onCreateViewHolder(ViewGroup parent, int viewType)`: Método para crear una nueva instancia de `PokemonAlignmentDetailViewHolder`.
- `onBindViewHolder(PokemonAlignmentDetailViewHolder holder, int position)`: Método para asociar los datos de un Pokémon a la vista correspondiente en el RecyclerView.
- `getItemCount()`: Método para obtener el número de elementos en la lista de Pokémon.
- `PokemonAlignmentDetailViewHolder`: Clase interna que representa la vista de un elemento individual en el RecyclerView.

#### PokemonAlignmentDetailViewHolder

##### Propósito:
Clase interna que representa la vista de un elemento individual en el RecyclerView para la alineación de Pokémon.

##### Atributos Principales:
- `ivPokemonAlignmentDetail`: ImageView para mostrar la imagen del Pokémon.
- `tvPokemonNameAlignment`: TextView para mostrar el nombre del Pokémon.
- `pbLifeAlignment`: ProgressBar para mostrar la vida del Pokémon.
- `pbAttackAlignment`: ProgressBar para mostrar el ataque del Pokémon.
- `pbDefenseAlignment`: ProgressBar para mostrar la defensa del Pokémon.
- `pbSpeedAlignment`: ProgressBar para mostrar la velocidad del Pokémon.

##### Métodos Principales:
- `PokemonAlignmentDetailViewHolder(View itemView)`: Constructor de la clase.
- `onBindPokemonAlignmentDetail(PokemonDTO pokemon)`: Método para asociar los datos de un Pokémon a los elementos de la vista.
- `onClick(View v)`: Método para manejar los clics en los elementos de la vista.

#### AlineacionAdapter

##### Propósito:
Clase que implementa un adaptador para la alineación de Pokémon en el juego Pokémon.

##### Atributos Principales:
- `alineacion`: Lista de Pokémon para alinear.

##### Métodos Principales:
- `onCreateViewHolder(ViewGroup parent, int viewType)`: Método para crear una nueva instancia de `AlieacionViewHolder`.
- `onBindViewHolder(AlieacionViewHolder holder, int position)`: Método para asociar los datos de un Pokémon a la vista correspondiente en el RecyclerView.
- `getItemCount()`: Método para obtener el número de elementos en la lista de Pokémon.

#### AlieacionViewHolder

##### Propósito:
Clase interna que representa la vista de un elemento individual en el RecyclerView para la alineación de Pokémon.

##### Atributos Principales:
- `ivPokemon`: ImageView para mostrar la imagen del Pokémon.
- `ivBackground`: ImageView para mostrar el fondo de la alineación.
- `tvAlineacion`: TextView para mostrar la zona de alineación del Pokémon.
- `pbLifeAlineacion`: ProgressBar para mostrar la vida del Pokémon en la alineación.

##### Métodos Principales:
- `AlieacionViewHolder(View itemView)`: Constructor de la clase.
- `onBindAlineacion(PokemonDTO pokemon)`: Método para asociar los datos de un Pokémon a los elementos de la vista.

#### OponentAdapter

##### Propósito:
Clase que implementa un adaptador para mostrar la lista de oponentes disponibles para el combate en el juego Pokémon.

##### Atributos Principales:
- `oponentes`: Lista de oponentes disponibles.
- `listener`: Interfaz para gestionar los eventos de clic en los elementos del RecyclerView.

##### Métodos Principales:
- `onCreateViewHolder(ViewGroup parent, int viewType)`: Método para crear una nueva instancia de `OponentViewHolder`.
- `onBindViewHolder(OponentViewHolder holder, int position)`: Método para asociar los datos de un oponente a la vista correspondiente en el RecyclerView.
- `getItemCount()`: Método para obtener el número de elementos en la lista de oponentes.

#### OponentViewHolder

##### Propósito:
Clase interna que representa la vista de un elemento individual en el RecyclerView para un oponente en el combate de Pokémon.

##### Atributos Principales:
- `ivOponent`: ImageView para mostrar la imagen del oponente.
- `tvNameOponent`: TextView para mostrar el nombre del oponente.
- `tvSurnameOponent`: TextView para mostrar el apellido del oponente.
- `tvVictories`: TextView para mostrar el número de victorias del oponente.
- `rvPokemonsOponent`: RecyclerView para mostrar los Pokémon del oponente.

##### Métodos Principales:
- `OponentViewHolder(View itemView)`: Constructor de la clase.
- `onBindOponent(EntrenadorDTO entrenadorDTO)`: Método para asociar los datos de un oponente a los elementos de la vista.
- `onClick(View v)`: Método para manejar los clics en los elementos de la vista.

#### PokemonAdapter

##### Propósito:
Clase que implementa un adaptador para mostrar la lista de Pokémon en el juego Pokémon.

##### Atributos Principales:
- `pokemons`: Lista de Pokémon a mostrar.
- `listener`: Interfaz para gestionar los eventos de clic en los elementos del RecyclerView.

##### Métodos Principales:
- `onCreateViewHolder(ViewGroup parent, int viewType)`: Método para crear una nueva instancia de `PokemonViewHolder`.
- `onBindViewHolder(PokemonViewHolder holder, int position)`: Método para asociar los datos de un Pokémon a la vista correspondiente en el RecyclerView.
- `getItemCount()`: Método para obtener el número de elementos en la lista de Pokémon.

#### PokemonViewHolder

##### Propósito:
Clase interna que representa la vista de un elemento individual en el RecyclerView para un Pokémon.

##### Atributos Principales:
- `ivPokemon`: ImageView para mostrar la imagen del Pokémon.
- `tvPokemon`: TextView para mostrar el nombre del Pokémon.

##### Métodos Principales:
- `PokemonViewHolder(View itemView)`: Constructor de la clase.
- `onBindPokemon(PokemonDTO pokemon)`: Método para asociar los datos de un Pokémon a los elementos de la vista.
- `onClick(View v)`: Método para manejar los clics en los elementos de la vista.

#### PokemonAdapter

#### Propósito
Clase que implementa un adaptador para mostrar la lista de Pokémon en el juego Pokémon.

##### Atributos Principales
- `pokemons`: Lista de Pokémon a mostrar.
- `listener`: Interfaz para gestionar los eventos de clic en los elementos del RecyclerView.

##### Métodos Principales
- `onCreateViewHolder(ViewGroup parent, int viewType)`: Método para crear una nueva instancia de `PokemonViewHolder`.
- `onBindViewHolder(PokemonViewHolder holder, int position)`: Método para asociar los datos de un Pokémon a la vista correspondiente en el RecyclerView.
- `getItemCount()`: Método para obtener el número de elementos en la lista de Pokémon.

#### PokemonViewHolder

##### Propósito
Clase interna que representa la vista de un elemento individual en el RecyclerView para un Pokémon.

##### Atributos Principales
- `ivPokemon`: ImageView para mostrar la imagen del Pokémon.
- `tvPokemon`: TextView para mostrar el nombre del Pokémon.

##### Métodos Principales
- `PokemonViewHolder(View itemView)`: Constructor de la clase.
- `onBindPokemon(PokemonDTO pokemon)`: Método para asociar los datos de un Pokémon a los elementos de la vista.
- `onClick(View v)`: Método para manejar los clics en los elementos de la vista.

#### TrainerPokemonAdapter

##### Propósito
Clase que implementa un adaptador para mostrar la lista de Pokémon del entrenador en el juego Pokémon.

##### Atributos Principales
- `pokemons`: Lista de Pokémon del entrenador a mostrar.
- `listener`: Interfaz para gestionar los eventos de clic largo en los elementos del RecyclerView.

##### Métodos Principales
- `onCreateViewHolder(ViewGroup parent, int viewType)`: Método para crear una nueva instancia de `TrainerPokemonViewHolder`.
- `onBindViewHolder(TrainerPokemonViewHolder holder, int position)`: Método para asociar los datos de un Pokémon del entrenador a la vista correspondiente en el RecyclerView.
- `getItemCount()`: Método para obtener el número de elementos en la lista de Pokémon del entrenador.

#### TrainerPokemonViewHolder

##### Propósito
Clase interna que representa la vista de un elemento individual en el RecyclerView para un Pokémon del entrenador.

##### Atributos Principales
- `ivPokemon`: ImageView para mostrar la imagen del Pokémon del entrenador.
- `ivBackground`: ImageView para el fondo de la vista.
- `tvAlineacion`: TextView para mostrar el nombre del Pokémon del entrenador.
- `pbLifeAlineacion`: ProgressBar para mostrar la vida del Pokémon del entrenador.

##### Métodos Principales
- `TrainerPokemonViewHolder(View itemView)`: Constructor de la clase.
- `onBindPokemon(PokemonDTO pokemon)`: Método para asociar los datos de un Pokémon del entrenador a los elementos de la vista.
- `onLongClick(View v)`: Método para manejar los clics largos en los elementos de la vista.

#### WelcomeAdapter

##### Propósito
Clase que implementa un adaptador para mostrar la lista de Pokémon alineados en la pantalla de bienvenida del juego Pokémon.

##### Atributos Principales
- `pokemonsAlineados`: Lista de Pokémon alineados a mostrar en la pantalla de bienvenida.

##### Métodos Principales
- `onCreateViewHolder(ViewGroup parent, int viewType)`: Método para crear una nueva instancia de `WelcomeViewHolder`.
- `onBindViewHolder(WelcomeViewHolder holder, int position)`: Método para asociar los datos de un Pokémon alineado a la vista correspondiente en el RecyclerView.
- `getItemCount()`: Método para obtener el número de elementos en la lista de Pokémon alineados.

#### WelcomeViewHolder

##### Propósito
Clase interna que representa la vista de un elemento individual en el RecyclerView para un Pokémon alineado en la pantalla de bienvenida.

##### Atributos Principales
- `ivPokemonAlineacion`: ImageView para mostrar la imagen del Pokémon alineado.
- `tvAlineacion`: TextView para mostrar el nombre del Pokémon alineado.
- `pbLifeAlineacion`: ProgressBar para mostrar la vida del Pokémon alineado.

##### Métodos Principales
- `WelcomeViewHolder(View itemView)`: Constructor de la clase.
- `onBindWelcome(PokemonDTO pokemonDTO)`: Método para asociar los datos de un Pokémon alineado a los elementos de la vista.

## Resumen de la Clase LoginPreference

### Propósito:
La clase `LoginPreference` gestiona las preferencias de inicio de sesión de un usuario en la aplicación.

### Atributos Principales:
- `etUsername`: EditText para el nombre de usuario.
- `etPassword`: EditText para la contraseña.
- `etIP`: EditText para la dirección IP del servidor.
- `etPuerto`: EditText para el puerto del servidor.
- `tvToken`: TextView para mostrar el token de inicio de sesión.
- `preferences`: Objeto SharedPreferences para almacenar las preferencias de inicio de sesión.

### Métodos Principales:
- `onCreate(Bundle savedInstanceState)`: Método para inicializar la actividad y cargar las preferencias de inicio de sesión.
- `onFocusChange(View v, boolean hasFocus)`: Método para guardar las preferencias de inicio de sesión cuando los EditText pierden el foco.

### Funcionalidad:
- Al abrir la actividad, se recuperan las preferencias de inicio de sesión almacenadas y se muestran en los EditText correspondientes.
- Cuando un EditText pierde el foco, se guardan las preferencias actualizadas en el objeto SharedPreferences.

## Resumen de la Clase LoginPreference

### Propósito:
La clase `LoginPreference` gestiona las preferencias de inicio de sesión de un usuario en la aplicación.

### Atributos Principales:
- `etUsername`: EditText para el nombre de usuario.
- `etPassword`: EditText para la contraseña.
- `etIP`: EditText para la dirección IP del servidor.
- `etPuerto`: EditText para el puerto del servidor.
- `tvToken`: TextView para mostrar el token de inicio de sesión.
- `preferences`: Objeto SharedPreferences para almacenar las preferencias de inicio de sesión.

### Métodos Principales:
- `onCreate(Bundle savedInstanceState)`: Método para inicializar la actividad y cargar las preferencias de inicio de sesión.
- `onFocusChange(View v, boolean hasFocus)`: Método para guardar las preferencias de inicio de sesión cuando los EditText pierden el foco.

### Funcionalidad:
- Al abrir la actividad, se recuperan las preferencias de inicio de sesión almacenadas y se muestran en los EditText correspondientes.
- Cuando un EditText pierde el foco, se guardan las preferencias actualizadas en el objeto SharedPreferences.
