## Development

### start coding
```
npm run dev
```

### eslint
* Enable eslint with IDE - https://eslint.org/docs/user-guide/integrations
* Run eslint before commit or push
```
npm run eslint
```

### stylelint
* Enable stylelint with IDE
* Run stylelint before commit or push
* Rules refers to [Offical](https://stylelint.io/user-guide/example-config/) or [Ant Design](https://github.com/ant-design/ant-design/blob/master/.stylelintrc)
```
npm run stylelint
```

### git hooks
* Update your git client >= 2.9
* Run **git config core.hooksPath .githooks**
* This would ensure run eslint and stylelint before push code to remote server
