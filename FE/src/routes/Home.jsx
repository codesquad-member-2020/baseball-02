import React from "react";
import { PATH } from "Utils/const";
import { Container, Title, LoginBtn, StyledLink } from "Styles/Home";

const Home = () => {
	return (
		<Container>
			<Title>온라인 야구게임</Title>
			<LoginBtn>
				<StyledLink to={PATH.TEAM_CHOICE}>LOG IN</StyledLink>
			</LoginBtn>
		</Container>
	);
};

export default Home;
