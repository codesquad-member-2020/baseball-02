import styled from "styled-components";
import { Link } from "react-router-dom";

const Container = styled.div`
	width: 100%;
	height: 100%;
	display: flex;
	flex-direction: column;
	justify-content: space-around;
	align-items: center;
`;

const Title = styled.h1`
	font-size: 50px;
`;

const LoginBtn = styled.button`
	border: 5px double #37f734;
	font-size: 24px;
	width: 42%;
	height: 50px;
	display: flex;
	justify-content: center;
	align-items: center;
`;

const StyledLink = styled(Link)`
	width: 100%;
	height: 100%;
`;

export { Container, Title, LoginBtn, StyledLink };
