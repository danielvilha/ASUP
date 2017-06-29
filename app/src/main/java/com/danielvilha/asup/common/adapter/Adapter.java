package com.danielvilha.asup.common.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.danielvilha.asup.R;
import com.danielvilha.asup.common.entity.Answer;
import com.danielvilha.asup.common.entity.Quiz;
import com.danielvilha.infra.mvc.base.BaseFragment;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Daniel Vilha 29/06/17.
 */

public class Adapter extends BaseExpandableListAdapter {

    private BaseFragment fragment;
    private List<Quiz> _listDataHeader; // header titles
    private HashMap<Quiz, List<Answer>> _listDataChild; // child data in format of header title, child title

    public Adapter(BaseFragment fragment, List<Quiz> listDataHeader, HashMap<Quiz, List<Answer>> listChildData) {
        this.fragment = fragment;
        this._listDataHeader = listDataHeader;
        this._listDataChild = listChildData;
    }

    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition)).get(childPosititon);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        final Answer answer = (Answer) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.fragment.getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.adapter_item, null);
        }

        TextView txtListChild = (TextView) convertView.findViewById(R.id.lblListItem);
        txtListChild.setText(String.format("%s - Questão: %d - Resposta: %.2f", answer.getType().toString(), answer.getQuestionNumber(), answer.getValue()));
        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this._listDataHeader.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this._listDataHeader.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        Quiz quiz = (Quiz) getGroup(groupPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.fragment.getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.adapter_group, null);
        }

        TextView lblListHeader = (TextView) convertView.findViewById(R.id.lblListHeader);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(String.format("%s - %s",quiz.getType().toString(), quiz.getDate().toString()));

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
