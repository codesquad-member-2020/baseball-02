import styled from "styled-components";

const GridContainer = styled.div`
	display: grid;
	grid-template-columns: 550px 218px;
	grid-template-rows: 150px 450px;
`;

const Box = styled.div`
	:nth-child(1) {
		border-right: 3px solid #37f734;
		border-bottom: 3px solid #37f734;
	}
	:nth-child(2) {
		border-bottom: 3px solid #37f734;
	}
	:nth-child(3) {
		border-right: 3px solid #37f734;
	}
`;

export { GridContainer, Box };
