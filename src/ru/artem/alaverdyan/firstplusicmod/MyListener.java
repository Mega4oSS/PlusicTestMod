package ru.artem.alaverdyan.firstplusicmod;

import age.of.civilizations2.jakowski.lukasz.*;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;

import java.util.ArrayList;

public class MyListener extends PlusicEventListener {
    @Override
    public void changedMenu(Menu menu) {
        if(menu == Menu.eMAINMENU) {
            CFG.menuManager.menus.get(CFG.menuManager.MAINMENU).get(0).getMenuElement(0).setText(CFG.langManager.get("IMREPLACETHISTEXTWITHPAPI"));
            CFG.toast.setInView(CFG.langManager.get("HelloWorld") + "!", Color.BLUE);
        }
        FirstPlusicMod.activeMenu = menu;
    }

    @Override
    public ArrayList<CustomBuilding> registerBuildings(ArrayList<CustomBuilding> buildings) {
        buildings.add(CustomBuildingBuilder.create()
                .image("fort.png")
                .addLevel()
                .name("Test Building")
                .build_cost(0.4f)
                .build_movement_cost(3)
                .construction(10)
                .turn_goldIncome(100)
                .image("fort.png")
                .custom_action(new Building_Action() {
                    @Override
                    public void init() {
                        CFG.toast.setInView("Fucking fuck, you build this stupid building", Color.RED);
                    }

                    @Override
                    public void buildMenuHoverElement(ArrayList<MenuElement_Hover_v2_Element2> nElements) {
                        ArrayList<MenuElement_Hover_v2_Element_Type> nData = new ArrayList<MenuElement_Hover_v2_Element_Type>();
                        nData.add(new MenuElement_Hover_v2_Element_Type_Text("TEST", Color.BLUE));
                        nElements.add(new MenuElement_Hover_v2_Element2(nData));
                        nData.clear();
                    }
                })
                .tech_level(0.4f)
                .build());
        return buildings;
    }

    @Override
    public boolean keyUp(int keycode) {
        if(keycode == Input.Keys.O) {
            FirstPlusicMod.drawMem = !FirstPlusicMod.drawMem;
            return true;
        }
        return false; //оборвать выполнение метода в аоц или нет (чтобы аоцка не думала что это для неё нажато было, хз как объяснить)
    }
}
