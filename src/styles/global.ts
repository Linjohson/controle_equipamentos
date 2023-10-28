import { createGlobalStyle } from "styled-components";

export const GlobalStyle = createGlobalStyle `
:root {
    --primary-color: #163D54;
    --secondary-color: #CDCDCD;
    --button-color: #D9D9D9;
    --button-radius: 10px;
}
* {
    margin: 0;
    padding: 0;

    box-sizing: border-box;

    focus {
        outline: 0;
    }
}
`;