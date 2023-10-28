import React, { useState } from 'react'
import { ThemeProvider } from "styled-components";
import { defaultTheme } from "./styles/themes/default";
import style from '../src/css/Style.module.css';
import {AddEquip} from './AddEquip';
import {AddLoc} from './AddLoc';
import {AddProf} from './AddProf';

export function SideBar() {
          let [ConteudoAtivo, SetConteudoAtivo] = useState('apresentacao') 
  return (
    <ThemeProvider theme={defaultTheme}>
      <article className="row">
        {/* SideBar */}
        <main className={`p-1 d-flex flex-column flex-grow-1 align-items-center col-lg-2 col-md-3 col-sm-4 col-5 ${style.sideBar}`}>

          <button id="btn_con" type="button" className="col-lg-8 col-md-9 col-sm-10 col-11 btn btn-secondary d-flex align-items-center justify-content-center m-2" 
          onClick={()=> SetConteudoAtivo('AddEquip')}>
            CADASTRAR EQUIPAMENTO
          </button>
          <button id="btn_add" type="button" className="col-lg-8 col-md-9 col-sm-10 col-11 btn btn-secondary d-flex align-items-center justify-content-center m-2"
          onClick={()=>SetConteudoAtivo('AddProf')}>
            CADASTRAR PROFESSOR
          </button>
          <button id="btn_alt" className=" col-lg-8 col-md-9 col-sm-10 col-11 btn btn-secondary d-flex align-items-center justify-content-center m-2"
          onClick={()=>SetConteudoAtivo('AddLoc')}>
            REALIZAR ALOCAÇÃO
          </button>

        </main>
        {/* TopBar */}
        <main className="p-0 m-0 col-lg-10 col-md-9 col-sm-8" id="Navbar">
          <nav className="navbar bg-body-tertiary">
            <span className="navbar-brand mb-0 h1 m-1" id="navbar">BEM VINDO!</span>
          </nav>


          {/* DataContent */}
          <div className="apresentacao m-1 col-lg-10 col-md-9 col-sm-8">
            {ConteudoAtivo === 'apresentacao' &&(
                <p className="text fs-3 m-0">
              div de apresentação (apresentar antes de apertar em qualquer botão da SideBar)
              </p>
            )}

            {ConteudoAtivo === 'AddEquip' && <AddEquip />}
            {ConteudoAtivo === 'AddProf' && <AddProf />}
            {ConteudoAtivo === 'AddLoc' && <AddLoc />}

          </div>

        </main>
      </article>
    </ThemeProvider>
  )
}
