import React from "react";
import player from "../assets/player.png";
import { Container, ImageContainer, NameTag } from "Styles/Player";

const Player = () => {
	return (
		<Container>
			<ImageContainer>
				<img src={player} />
			</ImageContainer>
			<NameTag>류현진</NameTag>
		</Container>
	);
};

export default Player;
