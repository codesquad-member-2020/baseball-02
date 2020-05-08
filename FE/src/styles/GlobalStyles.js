import { createGlobalStyle } from "styled-components";
import reset from "styled-reset";

const GlobalStyles = createGlobalStyle`
  ${reset};
  * {
    box-sizing: border-box;
    font-family: 'NeoDunggeunmo';
  }
  @font-face {
    font-family: 'NeoDunggeunmo';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2001@1.3/NeoDunggeunmo.woff') format('woff');
    font-weight: normal;
    font-style: normal;
  }
  body {
    font-family: 'NeoDunggeunmo';
    color: #37F734;
    background: #2D2D2D;
  }
  button {
    background: none;
    color: inherit;
    padding: 0;
    border: none;
    cursor: pointer;
    outline: inherit;
}
  a, a:visited, a:hover, a:active {
    text-decoration: none;
    color: inherit;
  }
`;

export default GlobalStyles;
