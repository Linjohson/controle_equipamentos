import { ThemeProvider } from "styled-components";
import { defaultTheme } from "./styles/themes/default";
import style from '../src/css/Style.module.css';

export function AddProf(){
	return(

	<div className="adicionar m-1 col-lg-10 col-md-9 col-sm-8">
        <p className="text fs-3 m-0">
              div de cadastrar professor
		<head>
			<div class="table">
				<table>
					<thead>
						<tr>
							<th>Nome do Professor(a)</th>
							<th>Turma</th>
							<th>Turno</th>
							<th>Horário</th>
						</tr>
					</thead>
				</table>
			</div>
	        <body>
			<h3>Professores cadastrado</h3>
		</body>  
		</head>
        </p>
	</div>

)}
