<template>
  <div class="wrapper">
    <header>
      <nav><!-- Enlaces de navegación-->
        <ul>
          <li>
            <a href="/">Inicio</a>
          </li>
          <li>
            <a href="/lista">Lista emergencias</a>
          </li>
          <li>
            <a href="/nuevo">Nueva emergencia</a>
          </li>
          <li>
            <a href="/actualizar">Actualizar emergencia</a>
          </li>
          <li>
            <a href="/eliminar">Eliminar emergencia</a>
          </li>
      
        </ul>
      </nav>
    </header>
      <Nuxt /><!-- Contenidos de las páginas-->
    <footer><!-- contenido del footer -->
      
      TBD
    </footer>
  </div>
</template>

<style>
html {
  font-family:
    'Source Sans Pro',
    -apple-system,
    BlinkMacSystemFont,
    'Segoe UI',
    Roboto,
    'Helvetica Neue',
    Arial,
    sans-serif;
  font-size: 16px;
  word-spacing: 1px;
  -ms-text-size-adjust: 100%;
  -webkit-text-size-adjust: 100%;
  -moz-osx-font-smoothing: grayscale;
  -webkit-font-smoothing: antialiased;
  box-sizing: border-box;
  color:#dde5ee;
}

*,
*::before,
*::after {
  box-sizing: border-box;
  margin: 0;
}

.button--green {
  display: inline-block;
  border-radius: 4px;
  border: 1px solid #b2c9e2;
  color: #b2c9e2;
  text-decoration: none;
  padding: 10px 30px;
}

.button--green:hover {
  color: #b2c9e2;
  background-color: #b2c9e2;
}

.button--grey {
  display: inline-block;
  border-radius: 4px;
  border: 1px solid #b2c9e2;
  color: #b2c9e2;
  text-decoration: none;
  padding: 10px 30px;
  margin-left: 15px;
}

.button--grey:hover {
  color: #fff;
  background-color: #35495e;
}
</style>
