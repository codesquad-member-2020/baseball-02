import styled from "styled-components";

const BallCountContainer = styled.div`
	position: absolute;
	top: 10px;
	left: 15px;
	color: #37f734;
	font-size: 20px;
`;

const BallBox = styled.div`
	display: flex;
`;

const LightContainer = styled.div`
	display: flex;
	align-items: center;
	margin-left: 5px;
	margin-bottom: 2px;
`;

const Light = styled.div`
	width: 10px;
	height: 15px;
	background: #37f734;
	:not(:last-child) {
		margin-right: 5px;
	}
`;

export { BallCountContainer, BallBox, LightContainer, Light };
