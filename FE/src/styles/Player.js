import styled from "styled-components";

const Container = styled.div`
	display: flex;
	flex-direction: column;
	justify-content: center;
	position: absolute;
	top: 360px;
	left: 250px;
`;

const ImageContainer = styled.div`
	width: 50px;
	display: flex;
	justify-content: center;
`;

const NameTag = styled.div`
	color: #1d1f20;
	background: #37f734;
	text-align: center;
	width: 50px;
`;

export { Container, ImageContainer, NameTag };
