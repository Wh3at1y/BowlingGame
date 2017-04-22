package game.controller;

public class ButtonController
	{
		private GameController baseController;
		private boolean isMainMenuShowing;

		public ButtonController()
			{
				this.baseController = baseController;
				this.isMainMenuShowing = true;

			}

		public void newGameButtonOperation()
			{

				if (isMainMenuShowing)
					{
						//baseController.getMainMenuPanel().setVisible(false);
						//baseController.getNewGamePanel().setVisible(true);
						isMainMenuShowing = false;
					}
				else
					{
						//baseController.getMainMenuPanel().setVisible(true);
						//baseController.getNewGamePanel().setVisible(false);
						isMainMenuShowing = true;
					}
			}

		public void loadButtonOperation()
			{
				if (isMainMenuShowing)
					{
						//baseController.getMainMenuPanel().setVisible(false);
						isMainMenuShowing = false;
					}
				else
					{
						//baseController.getMainMenuPanel().setVisible(true);
						isMainMenuShowing = true;
					}
			}

		public void optionsButtonOperation()
			{
				if (isMainMenuShowing)
					{
						//baseController.getMainMenuPanel().setVisible(false);
						//baseController.getOptionsPanel().setVisible(true);
						isMainMenuShowing = false;
					}
				else
					{
						//baseController.getMainMenuPanel().setVisible(true);
						//baseController.getOptionsPanel().setVisible(false);
						//baseController.getNewGamePanel().setVisible(false);
						isMainMenuShowing = true;
					}
			}

		
	}
