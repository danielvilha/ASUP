package com.danielvilha.infra.mvc.base;



import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;

import com.danielvilha.infra.mvc.annotations.FragmentModel;

/**
 * Created by danielvilha.
 */

public class FragmentModelFactory {
    private FragmentModelFactory(){}
    private static FragmentModelFactory instance;
    private static Map<String, BaseFragmentModel> mapModel;

    public static FragmentModelFactory getInstance(){
        if (instance == null){
            instance = new FragmentModelFactory();
            mapModel = new HashMap<String, BaseFragmentModel>();
        }
        return instance;
    }

    private String getFragmentModelName(Class clazz){
        Annotation annotation = clazz.getAnnotation(FragmentModel.class);
        if(annotation instanceof FragmentModel){
            FragmentModel modelName = (FragmentModel) annotation;
            if (modelName.path() != null && modelName.path().trim().length() > 0){
                return modelName.path();
            }
        }
        return null;
    }

    public BaseFragmentModel getFragmentModel(BaseFragment fragment) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
        if (shouldIgnore(fragment.getClass())){
            return null;
        }
        BaseFragmentModel fragmentModel = mapModel.get(fragment.getUuid());
        if (fragmentModel == null){
            String fragmentName = getFragmentModelName(fragment.getClass());
            if (fragmentName == null){
                throw new IllegalArgumentException("Necessário setar a anotação @FragmentModel(path=) na fragment");
            }
            Class c = Class.forName(fragmentName);
            fragmentModel = (BaseFragmentModel) c.newInstance();
            mapModel.put(fragment.getUuid(), fragmentModel);
        }
        return fragmentModel;
    }

    public void cleanFragmentModel(BaseFragment fragment){
        mapModel.remove(fragment.getUuid());
    }

    private boolean shouldIgnore(Class clazz){
        Annotation annotation = clazz.getAnnotation(FragmentModel.class);
        if(annotation instanceof FragmentModel){
            FragmentModel modelName = (FragmentModel) annotation;
            return modelName.ignore();
        }
        return false;
    }
}
