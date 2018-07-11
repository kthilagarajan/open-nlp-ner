/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mynlp.nlporgfinder.core;

import com.mynlp.nlporgfinder.utils.Constants;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.util.InvalidFormatException;
import opennlp.tools.util.Span;

/**
 *
 * @author User
 */
public class NLPOrgFinder {

    public NLPOrgFinder() {
    }
    public String Tokens[];

    public String initOrgFinder(String textToFind) {
        Constants constants = new Constants();
        NLPOrgFinder nlpOrgFinder = new NLPOrgFinder();
//        textToFind = "Whatsapp is bought by Facebook";
        nlpOrgFinder.tokenization(textToFind);
        System.out.println(Arrays.toString(nlpOrgFinder.Tokens));
        return nlpOrgFinder.orgfind(nlpOrgFinder.Tokens);
    }
    Constants constants = new Constants();

    public String orgfind(String cnt[]) {
        InputStream is;
        TokenNameFinderModel tnf;
        NameFinderME nf;
        String sd = "";
        try {
            is = new FileInputStream(constants.getModel_path());
            tnf = new TokenNameFinderModel(is);
            nf = new NameFinderME(tnf);
            Span sp[] = nf.find(cnt);
            String a[] = Span.spansToStrings(sp, cnt);
            StringBuilder fd = new StringBuilder();
            int l = a.length;
            List<String> resultList = new ArrayList<String>();
            for (int j = 0; j < l; j++) {
                resultList.add(a[j]);
//                fd = fd.append(a[j] + ",");

            }

            for (int x = 0; x < resultList.size(); x++) {
                if ("".equals(resultList.get(x).trim()) || resultList.get(x) == null) {
                    resultList.remove(x);
                }
            }
            sd = org.apache.tomcat.util.buf.StringUtils.join(resultList);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sd;

    }

    public void tokenization(String tokens) {
        InputStream is;
        TokenizerModel tm;
        try {
            is = new FileInputStream(constants.getToken_model());
            tm = new TokenizerModel(is);
            Tokenizer tz = new TokenizerME(tm);
            Tokens = tz.tokenize(tokens);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
