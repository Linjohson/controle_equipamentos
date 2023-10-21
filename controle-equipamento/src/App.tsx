import { ThemeProvider } from "styled-components";
import { defaultTheme } from "./styles/themes/default";
import style from '../src/css/Style.module.css';

export function App() {
  return (
    <ThemeProvider theme={defaultTheme}>
      <article className="row">
        {/* SideBar */}
        <main className={`p-1 d-flex flex-column flex-grow-1 align-items-center col-lg-2 col-md-3 col-sm-4 col-5 ${style.sideBar}`}>

          <button id="btn_con" type="button" className="col-lg-8 col-md-9 col-sm-10 col-11 btn btn-secondary d-flex align-items-center justify-content-center m-2">
            CADASTRAR EQUIPAMENTO
          </button>
          <button id="btn_add" type="button" className="col-lg-8 col-md-9 col-sm-10 col-11 btn btn-secondary d-flex align-items-center justify-content-center m-2">
            CADASTRAR PROFESSOR
          </button>
          <button id="btn_alt" className=" col-lg-8 col-md-9 col-sm-10 col-11 btn btn-secondary d-flex align-items-center justify-content-center m-2">
            REALIZAR ALOCAÇÃO
          </button>

        </main>
        {/* TopBar */}
        <main className="p-0 m-0 col-lg-10 col-md-9 col-sm-8" id="Navbar">
          <nav className="navbar bg-body-tertiary">
            <span className="navbar-brand mb-0 h1 m-1" id="navbar">BEM VINDO!</span>
          </nav>

          {/* HomeContent */}
          <div className="apresentacao m-1 col-lg-10 col-md-9 col-sm-8">
            <p className="text fs-3 m-0">
              div de apresentação (apresentar antes de apertar em qualquer botão da SideBar)
            </p>
          </div>

          {/* AddEquip */}
          <div className="consultar m-1 col-lg-10 col-md-9 col-sm-8">
            <p className="text fs-3 m-0">
              div de cadastrar equipamento
            </p>
          </div>

          {/* AddProf */}
          <div className="adicionar m-1 col-lg-10 col-md-9 col-sm-8">
            <p className="text fs-3 m-0">
              div de cadastrar professor
            </p>
          </div>

          {/* AddLoc */}
          <div className="alterar m-1 col-lg-10 col-md-9 col-sm-8">
            <p className="text fs-3 m-0">
              div de agendar locação
            </p>
          </div>

        </main>
      </article>
    </ThemeProvider>
  )
}
