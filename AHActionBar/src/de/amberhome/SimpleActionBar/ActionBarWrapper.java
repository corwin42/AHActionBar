package de.amberhome.SimpleActionBar;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.ActivityObject;
import anywheresoftware.b4a.BA.Author;
import anywheresoftware.b4a.BA.Events;
import anywheresoftware.b4a.BA.Hide;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.BA.Version;
import anywheresoftware.b4a.objects.ViewWrapper;
import de.amberhome.SimpleActionBar.ActionBar.Action;

@Version(1.0f)
@Author("Markus Stipp")

@ActivityObject
@Events(values = { "ItemClicked(ItemID As Int)" })
@ShortName("AHActionBar")
/**
 * AHActionBar provides a action bar like view 
 */
public class ActionBarWrapper extends ViewWrapper<ActionBar> {

	/**
	 *  This library provides an ActionBar.
	 *  
	 *  The ActionBar was introduced in Android 3.0. This is a complete custom
	 *  implementation of an ActionBar so it is not really compatible with
	 *  the Android 3.0+ ActionBar. 
	 * 
	 *  This library is somewhat different to other libraries because it makes use
	 *  of standard Android resource files. Resource files cannot be published inside
	 *  a .jar file and so you have to copy them to your Basic4Android project directory.
	 *  
	 *  Copy the whole "res" directory structure to the "Objects" directory of your B4A
	 *  project and VERY IMPORTANT: make them READ ONLY! Otherwise B4A will delete them
	 *  when compiling. After you make any change to the Objecs/res directory use
	 *  "Clean project" menu item in B4A to force the compiler to recreate the R.java file.
	 *  
	 *  If you forget to make the resource files read only then you will most likely get
	 *  a ResourceNotFound exception when you try to use the ActiionBar.
	 *  
	 *  The object is highly based on an open source project by Johan Nilsson:
	 *  <link>Android-ActionBar|https://github.com/johannilsson/android-actionbar</link>
	 */
	public static void LIBRARY_DOC() {

	}

	protected String mEventName;
	private Drawable mBackground;
	
	/**
	 * 
	 * Initializes the object.
	 * 
	 * EventName - Sets the sub that will handle the event.
	 */
	public void Initialize(BA ba, String EventName) {
		Initialize2(ba, EventName, null);
	}
	
	
	/**
	 * 
	 * Initializes the object.
	 * 
	 * EventName - Sets the sub that will handle the event.
	 * Background - A backgrounddrawable for the background of the status bar. Should be a StateListDrawable to support item pressed state.
	 */
	public void Initialize2(BA ba, String EventName, Drawable Background)
	{
		if (Background != null)
			mBackground = Background;

		super.Initialize(ba, EventName);
		
	}

	@Hide
	public void innerInitialize(final BA ba, final String EventName, boolean keepOldObject) {
		if (!keepOldObject)
			setObject(new ActionBar(ba, null, mBackground, EventName.toLowerCase()));
		super.innerInitialize(ba, EventName, true);
		mEventName = EventName.toLowerCase();
//		if (ba.subExists(EventName + "_pagechanged")) {
//			((ViewPager)getObject()).setOnPageChangeListener(new ViewPager.OnPageChangeListener()
//			{
//
//				@Override
//				public void onPageScrollStateChanged(int arg0) {
//					// TODO Auto-generated method stub
//
//				}
//
//				@Override
//				public void onPageScrolled(int arg0, float arg1, int arg2) {
//					// TODO Auto-generated method stub
//
//				}
//
//				@Override
//				public void onPageSelected(int arg0) {
//					ba.raiseEvent(getObject(), EventName + "_pagechanged", new Object[] {((ViewPager)getObject()).getCurrentItem()});
//				}
//			});
//		}

	}	

	public ActionBarWrapper() {
		super();
	}

	/**
	 * 
	 * Set or get the background drawable.
	 */
	@Override
	public void setBackground(Drawable Background) {
		getObject().setBackgroundDrawable(Background);
	}
	
	@Override
	public Drawable getBackground() {
		return getObject().getBackground();
	}
	
	/**
	 * 
	 * Set or get the action item width. The height is always the height of the action bar.
	 * The default width is 42dip. You should set this value to the same value as your action bar height to get sqare action items.
	 */
	public void setActionWidth(int width) {
		getObject().setActionWidth(width);
	}
	
	public int getActionWidth() {
		return getObject().getActionWidth();
	}
	
	@Override
	@Hide
	public void setColor(int Color) {
		
	}
	
	@Override
	public void setEnabled(boolean Enabled) {
		getObject().setEnabled(Enabled);
	}
	
	@Override
	public boolean getEnabled() {
		return getObject().isEnabled();
	}
	
	@Override
	@Hide
	public boolean RequestFocus() {
		return false;
	}

	@Override
	@Hide
	public void SetBackgroundImage(Bitmap map) {
		
	}
	
	/**
	 * 
	 * Sets or gets the visible status of the ActionBar.
	 */
	public void setVisible(boolean flag) {
		if (flag) {
			getObject().show();
		}
		else {
			getObject().hide();
		}
	}

	public boolean getVisible() {
		return getObject().isShowing();
	}
	
	/**
	 * 
	 * Set or get the title of the action bar.
	 */
	public void setTitle(CharSequence Title) {
		getObject().setTitle(Title);
	}
	
	public CharSequence getTitle() {
		return getObject().getTitle();
	}
	
	/**
	 * 
	 * Sets or gets title status
	 */
	public void setShowTitle(boolean flag) {
		getObject().setDisplayShowTitleEnabled(flag);
	}
	
	public boolean getShowTitle() {
		return (getObject().getDisplayOptions() & ActionBar.DISPLAY_SHOW_TITLE) != 0;
	}
	
	/**
	 * 
	 * Set the title and subtitle color
	 */
	public void setTitleColor(int Color) {
		getObject().setTitleColor(Color);
	}
	
	/**
	 * 
	 * Set or get the subtitle. If you pass Null, the subtitle is hidden.
	 */
	public void setSubTitle(CharSequence Title) {
		getObject().setSubtitle(Title);
	}
	
	public CharSequence getSubTitle() {
		return getObject().getSubtitle();
	}
	
	/**
	 * 
	 * Set or get Home item status
	 */
	public void setShowHome(boolean flag) {
		getObject().setDisplayShowHomeEnabled(flag);
	}
	
	public boolean getShowHome() {
		return (getObject().getDisplayOptions() & ActionBar.DISPLAY_SHOW_HOME) != 0;
	}
	
	/**
	 * 
	 * Set or get the status if home item should be displayed as "up" item.
	 */
	public void setHomeAsUp(boolean flag) {
		getObject().setDisplayHomeAsUpEnabled(flag);
	}
	
	public boolean getHomeAsUp() {
		return (getObject().getDisplayOptions() & ActionBar.DISPLAY_HOME_AS_UP) != 0;
	}
	
	/**
	 * 
	 * Set or get property if a logo should be displayed instead of the application icon or home icon.
	 */
	public void setUseLogo(boolean flag) {
		getObject().setDisplayUseLogoEnabled(flag);
	}
	
	public boolean getUseLogo() {
		return (getObject().getDisplayOptions() & ActionBar.DISPLAY_USE_LOGO) != 0;
	}
	
	/**
	 * 
	 * Set the Home Logo
	 */
	public void setHomeLogo(Drawable Logo) {
		getObject().setHomeLogo(Logo);
	}

	/**
	 * 
	 * Set or get visibility of progress indicator 
	 */
	public void setProgressBarVisible(boolean flag) {
		if (flag)
			getObject().setProgressBarVisibility(ActionBar.VISIBLE);
		else
			getObject().setProgressBarVisibility(ActionBar.INVISIBLE);
	}
	
	public boolean getProgressBarVisible() {
		if (getObject().getProgressBarVisibility() == ActionBar.VISIBLE)
			return true;
		else
			return false;
	}
	
	
	/**
	 * 
	 * Gets the current count of actions added to the action bar
	 */
	public int getActionCount() {
		return getObject().getActionCount();
	}
	

	/**
	 * 
	 * Change the Icon for an action item
	 * 
	 * ItemID - ID of the Action
	 * Icon - New Icon
	 */
	public void SetActionIcon(int ItemID, Drawable Icon) {
		Action ac = getObject().findAction(ItemID);
		
		if (ac != null)
			ac.setIcon(Icon);
	}

	/**
	 * 
	 * Set the visibility of an action item
	 * 
	 * ItemID - Id of the action item to make visible or invisible
	 * Visible - Flag for status
	 */
	public void SetActionVisibility(int ItemID, boolean Visible) {
		Action ac = getObject().findAction(ItemID);
		
		if (ac != null)
			ac.setVisible(Visible);
	}
	
	/**
	 * 
	 * Get the visibility of an action item
	 * 
	 * ItemID - Id of the action item
	 * 
	 * Returns if the item is visible or not. Returns false if the item is not found.
	 */
	public boolean GetActionVisibility(int ItemID) {
		Action ac = getObject().findAction(ItemID);
		
		if (ac != null)
			return ac.isVisible();
		else
			return false;
	}
	
	/**
	 * 
	 * Change the padding for the icon. Useful to scale the icon.
	 * 
	 * ItemID - ID of the action for which the padding should be changed
	 * Padding - padding value
	 */
	public void SetActionPadding(int ItemID, int Padding) {
		Action ac = getObject().findAction(ItemID);
		
		if (ac != null)
			ac.setIconPadding(Padding);
	}
	
	/**
	 * 
	 * The ID of the action at the given index.
	 * 
	 * Index - index of the action item
	 *
	 * Returns -1 if the action item does not exist.
	 */
	public int GetActionID(int Index) {
		Action ac = getObject().getActionAt(Index);
		
		if (ac != null)
			return ac.getItemId();
		else
			return -1;
	}
	
	/**
	 * 
	 * Returns the View that represents the action item. This is not a standard B4A View but you can pass this to the AHQuickAction popup.
	 * 
	 * ItemID - ID of the action
	 * 
	 * Returns a reference to an Android Imagebutton. Null, if the action item is not found.
	 */
	public View GetActionView(int ItemID) {
		Action ac = getObject().findAction(ItemID);

		if (ac != null)
			return ac.mView;
		else
			return null;
	}
	
	/**
	 * 
	 * Add a home action item.
	 * 
	 * ItemId - Id for the home action item. This should be a unique id.
	 * Icon - a bitmap drawable with an icon.
	 */
	public void AddHomeAction(int ItemId, Drawable Icon) {
		Action action = getObject().newAction();
		
		action.setIcon(Icon);
		
		getObject().setHomeAction(action, ItemId);
	}

	/**
	 * 
	 * Add an action item at the last position.
	 * 
	 * ItemId - Id for the action item. This should be a unique id.
	 * Icon - Drawable of an Icon
	 */
	public void AddAction(int ItemId, Drawable Icon) {
		Action action = getObject().newAction(ItemId);
		action.setIcon(Icon);
		getObject().addAction(action);
	}
	
	
	/**
	 * 
	 * Add an action item at the last position.
	 * 
	 * ItemId - Id for the action item. This should be a unique id.
	 * Icon - Drawable of an Icon
	 * HelpText - Text to display for long click event
	 */
	public void AddAction2(int ItemId, Drawable Icon, CharSequence HelpText) {
		Action action = getObject().newAction(ItemId);
		action.setIcon(Icon);
		action.setHelpText(HelpText);
		getObject().addAction(action);
	}

	/**
	 * 
	 * Add an action item at the specified position.
	 * 
	 * ItemId - Id for the action item. This should be a unique id.
	 * Icon - Drawable of an Icon
	 * Index - Position of the new action item
	 */
	public void AddActionAt(int ItemId, Drawable Icon, int Index) {
		Action action = getObject().newAction(ItemId);
		action.setIcon(Icon);
		getObject().addAction(action, Index);
	}

	/**
	 * 
	 * Add an action item at the specified position.
	 * 
	 * ItemId - Id for the action item. This should be a unique id.
	 * Icon - Drawable of an Icon
	 * Index - Position of the new action item
	 * HelpText - Text to display for long click event
	 */
	public void AddActionAt2(int ItemId, Drawable Icon, int Index, CharSequence HelpText) {
		Action action = getObject().newAction(ItemId);
		action.setIcon(Icon);
		action.setHelpText(HelpText);
		getObject().addAction(action, Index);
	}

	/**
	 * 
	 * Remove the action with the specified itemID.
	 * 
	 * ItemId - Id of the action to be removed
	 */
	public void RemoveAction(int ItemId) {
		getObject().removeAction(ItemId);
	}
	
	/**
	 * 
	 * Remove the action at the specified index.
	 * 
	 * Index - Position of the item which should be removed.
	 */
	public void RemoveActionAt(int Index) {
		getObject().removeActionAt(Index);
	}
	
}