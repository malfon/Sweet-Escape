import java.io.IOException;
import java.nio.file.Paths;
import org.jsfml.graphics.*;
import org.jsfml.system.Vector2f;
import org.jsfml.window.*;
import org.jsfml.window.Mouse.Button;
import org.jsfml.window.event.*;

public class Main
{
	public static void main(String args[]) throws IOException, InterruptedException, IllegalMonitorStateException
	{
		int width=800, height=600;
		RenderWindow window = new RenderWindow();
		window.create(new VideoMode(width,height), "Sweet Escape");
    //game-state booleans
		boolean mainmenu = true;
		boolean campaign = false;
		
		//main menu
		Texture MainMenuTexture = new Texture();
		MainMenuTexture.loadFromFile(Paths.get("bin/MainMenu.png"));
		Sprite MainMenu = new Sprite();
		MainMenu.setTexture(MainMenuTexture);
		MainMenu.setPosition(Vector2f.ZERO);

    //Campaign Button
		Texture CampaignButtonTexture = new Texture();
		CampaignButtonTexture.loadFromFile(Paths.get("bin/CampaignButton.png"));
		Sprite CampaignButton = new Sprite();
		CampaignButton.setTexture(CampaignButtonTexture);
		CampaignButton.setPosition((width/2)-80, height/5);
		
		Texture CampaignButtonPushedTexture = new Texture();
		CampaignButtonPushedTexture.loadFromFile(Paths.get("bin/CampaignButtonPushed.png"));
		Sprite CampaignButtonPushed = new Sprite();
		CampaignButtonPushed.setTexture(CampaignButtonTexture);
		CampaignButtonPushed.setPosition((width/2)-80, height/5);
		
		while(window.isOpen())
		{
			window.clear();
			for(Event event : window.pollEvents())
			{
				switch(event.type)
				{
				case CLOSED:
					window.close();
					break;
				default:
					break;
				}
			}
			if(mainmenu)
			{
				window.draw(MainMenu);
				window.draw(CampaignButton);
				//Clicking the Campaign Button
				if(Mouse.isButtonPressed(Button.LEFT) &&
						Mouse.getPosition(window).x>CampaignButton.getPosition().x &&
						Mouse.getPosition(window).x<CampaignButton.getPosition().x+160 &&
						Mouse.getPosition(window).y>CampaignButton.getPosition().y &&
						Mouse.getPosition(window).y<CampaignButton.getPosition().y+75)
				{
					window.draw(CampaignButtonPushed);
					mainmenu=false;
					campaign = true;
				}
			}
			//Campaign game-state
			if(campaign)
			{
				
			}

			window.display();
		}
	}
}
