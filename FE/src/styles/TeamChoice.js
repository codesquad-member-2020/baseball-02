import styled from "styled-components";

const Wrapper = styled.div`
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	margin: auto;
`;

const Title = styled.h1`
	font-size: 22px;
	margin-bottom: 40px;
`;

const TeamContainer = styled.div`
	width: 400px;
	min-height: 300px;
	max-height: 300px;
	overflow-y: auto;
	display: flex;
	flex-direction: column;
	align-items: center;
	border: 3px solid #37f734;
	padding: 20px;
	margin-bottom: 40px;
`;

const Team = styled.div`
	border: 3px solid #37f734;
	width: 100%;
	min-height: 70px;
	font-size: 30px;
	display: flex;
	justify-content: center;
	align-items: center;
	cursor: pointer;
	:not(:last-child) {
		margin-bottom: 15px;
	}
`;

const PlayButton = styled.button`
	border: 5px double #37f734;
	font-size: 24px;
	width: 42%;
	height: 50px;
	display: flex;
	justify-content: center;
	align-items: center;
`;

export { Wrapper, Title, TeamContainer, Team, PlayButton };
