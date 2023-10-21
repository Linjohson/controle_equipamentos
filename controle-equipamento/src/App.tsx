import { ThemeProvider } from "styled-components";
import { defaultTheme } from "./styles/themes/default";

export function App() {
  return (
    <ThemeProvider theme={defaultTheme}>
      <h1>Fala zé</h1>
    </ThemeProvider>
    
  )
}
