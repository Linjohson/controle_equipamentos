import React, { useState } from 'react'
import ReactDOM from 'react-dom/client'
import { GlobalStyle } from './styles/global';
import 'bootstrap/dist/css/bootstrap.min.css';

import { SideBar } from './SideBar.tsx'
import { AddEquip } from './AddEquip.tsx'
import { AddLoc } from './AddLoc.tsx'
import { AddProf } from './AddProf.tsx'

ReactDOM.createRoot(document.getElementById('root')!).render(
  <React.StrictMode>
    <GlobalStyle />
    <SideBar />
  </React.StrictMode>,
)
